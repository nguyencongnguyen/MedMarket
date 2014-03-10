package com.med.market.bll.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.med.market.bll.service.ProductService;
import com.med.market.dao.CommonDAO;
import com.med.market.dao.ProductDAO;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;
import com.med.market.service.ImageService;
import com.med.market.util.ConfigurationManager;
import com.med.market.util.CrossSellProduct;
import com.med.market.util.SearchResult;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDao;
	private CommonDAO commonDao;
	private ImageService imageService;

	public void txAdd(Product product, long catId, long provinceId,
			String uploadedImages) throws Exception {
		Category cat = commonDao.getCategory(catId);
		Province province = commonDao.getProvince(provinceId);
		product.setCategory(cat);
		product.setProvince(province);
		Product addedProduct;
		List<Image> delImages = new ArrayList<Image>();
		if (product.getProductId() > 0) {
			product.setUpdateDate(new Date());
			addedProduct = product;
			productDao.update(product);
			
			List<Image> images = commonDao.getImagesByProductId(product.getProductId());
			for (Image image : images) {
				if (image != null && image.getUrl() != null && !"".equals(image.getUrl())) {
					if (!uploadedImages.contains(getImageName(image.getUrl()))) {
						delImages.add(image);
						commonDao.deleteImage(image);
					} else {
						uploadedImages = uploadedImages.replace(getImageName(image.getUrl())  + ",", "");
					}
				}
			}
		} else {
			product.setCreatedDate(new Date());
			product.setFriendlyUrl(generateFriendlyUrl(product.getName()));
			product.setApprove(false);
			product.setUpTime(Calendar.getInstance().getTimeInMillis());
			product.setUpIP("");
			addedProduct = productDao.addAndLoad(product);
		}

		String[] images = uploadedImages.split(",");
		String filePath = ConfigurationManager.getAsString("fileupload.path");
		if (images != null) {
			for (int i = 0; i < images.length; i++) {
				if (images[i] != null && !"".equals(images[i])) {
					String imageUrl = imageService
							.processImage(filePath, images[i]);
					Image image = new Image();
					image.setProduct(addedProduct);
					image.setUrl(imageUrl);
					if (product.getProductId() > 0) {
						String thumbnail = imageService.createThumbnail(getImageName(imageUrl), filePath);
						image.setThumbnail(thumbnail);
					} else {
						image.setThumbnail("");
					}
					image.setCreatedDate(new Date());
					commonDao.addImage(image);
				}
			}
		}
		
		// place at last lines for a safe transaction
		for (Image image : delImages) {
			imageService.deleteImage(getImageName(image.getUrl()));
		}
	}

	public void delete(Product product) {
		commonDao.deleteImageByProductId(product.getProductId());
		productDao.delete(product);
	}
	
	public void txApprove(Product product) throws Exception {
		productDao.update(product);
		List<Image> images = commonDao.getImagesByProductId(product.getProductId());
		for (Image image : images) {
			String thumbnail = imageService.createThumbnail(getImageName(image.getUrl()), ConfigurationManager.getAsString("fileupload.path"));
			image.setThumbnail(thumbnail);
			commonDao.updateImage(image);
		}
	}
	
	public Product getByUrl(String url) {
		return productDao.getByUrl(url);
	}

	public Product get(long id) {
		return productDao.get(id);
	}

	public List<CrossSellProduct> findSimilar(long productId, long catId,
			int num) {
		List<Product> products = productDao.findSimilar(catId, num + 1);
		List<CrossSellProduct> result = new ArrayList<CrossSellProduct>();
		int n = 0;
		for (Product product : products) {
			if (product.getProductId() != productId && n < num) {
				CrossSellProduct crossSell = new CrossSellProduct();
				crossSell.setProductId(product.getProductId());
				crossSell.setName(product.getName());
				crossSell.setDescription(product.getDescription());
				crossSell.setFriendlyUrl(product.getFriendlyUrl());
				crossSell.setPrice(product.getPrice());
				List<Image> images = commonDao.getImagesByProductId(product
						.getProductId());
				Image defaultImg = images.get(0);
				crossSell.setDefaultThumnbail(defaultImg.getThumbnail());
				result.add(crossSell);
				n++;
			}
		}
		return result;
	}

	public int searchTotal(String keyword, long provinceId, long catId) {
		return productDao.searchTotal(keyword, provinceId, catId);
	}

	public List<SearchResult> search(String keyword, int startIndex,
			int pageSize, long provinceId, long catId) {
		List<Product> products = productDao.search(keyword, startIndex,
				pageSize, provinceId, catId);
		return convertSearchResult(products);
	}
	
	public List<Product> txGetUnApprovedProducts() {
		return productDao.getUnApprovedProducts();
	}
	
	private List<SearchResult> convertSearchResult(List<Product> products) {
		List<SearchResult> result = new ArrayList<SearchResult>();
		if (products == null || products.size() == 0) {
			return result;
		}
		for (Product product : products) {
			List<Image> images = commonDao.getImagesByProductId(product
					.getProductId());
			Image defaultImg = images.get(0);
			SearchResult searchResult = new SearchResult(product,
					defaultImg.getThumbnail());
			result.add(searchResult);
		}
		return result;
	}

	private String getImageName(String url) {
		int idx = url.lastIndexOf("/");
		return url.substring(idx + 1, url.length());
	}

	private String generateFriendlyUrl(String name) {
		String str = "";
		try {
			str = URLEncoder.encode(name, "UTF-8");
			str = str.replace("%20", "-");
			str = str.replaceAll("%[a-zA-Z0-9][a-zA-Z0-9]", "");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		long time = Calendar.getInstance().getTimeInMillis();
		return str + "-" + time;
	}

	public ProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	public CommonDAO getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDAO commonDao) {
		this.commonDao = commonDao;
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

}
