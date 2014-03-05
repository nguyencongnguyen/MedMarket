package com.med.market.bll.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.med.market.bll.service.ProductService;
import com.med.market.dao.CommonDAO;
import com.med.market.dao.ProductDAO;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;
import com.med.market.service.ImageService;
import com.med.market.util.ConfigurationManager;
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
		product.setCreatedDate(new Date());
		product.setFriendlyUrl(generateFriendlyUrl(product.getName()));
		Product addedProduct = productDao.addAndLoad(product);

		String[] images = uploadedImages.split(",");
		String filePath = ConfigurationManager.getAsString("fileupload.path");
		for (int i = 0; i < images.length; i++) {
			if (images[i] != null && !"".equals(images[i])) {
				String imageUrl = imageService
						.processImage(filePath, images[i]);
				Image image = new Image();
				image.setProduct(addedProduct);
				image.setUrl(imageUrl);
				image.setThumbnail("");
				image.setCreatedDate(new Date());
				commonDao.addImage(image);
			}
		}
	}

	public Product getByUrl(String url) {
		return productDao.getByUrl(url);
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

	private List<SearchResult> convertSearchResult(List<Product> products) {
		List<SearchResult> result = new ArrayList<SearchResult>();
		if (products == null || products.size() == 0) {
			return result;
		}
		for (Product product : products) {
			List<Image> images = commonDao.getImagesByProductId(product.getProductId());
			Image defaultImg = images.get(0);
			SearchResult searchResult = new SearchResult(product, defaultImg.getThumbnail());
			result.add(searchResult);
		}
		return result;
	}

	private String generateFriendlyUrl(String name) {
		long time = Calendar.getInstance().getTimeInMillis();
		return name.replace(" ", "-") + "-" + time;
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
