package com.med.market.bll.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.med.market.dao.impl.CommonDAOImpl;
import com.med.market.dao.impl.ProductDAOImpl;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;
import com.med.market.service.ImageService;
import com.med.market.util.ConfigurationManager;

public class ProductServiceImpl {
    private ProductDAOImpl productDao;
    private CommonDAOImpl commonDao;
    private ImageService imageService;

    public void txAdd(Product product, long catId, long provinceId, String uploadedImages) throws Exception {
        Category cat = commonDao.getCategory(catId);
        Province province = commonDao.getProvince(provinceId);
        product.setCategory(cat);
        product.setProvince(province);
        product.setCreatedDate(new Date());
        product.setFriendlyUrl(generateFriendlyUrl(product.getName()));
        Product addedProduct = productDao.addAndLoad(product);
        
        String[] images = uploadedImages.split(",");
        String filePath = ConfigurationManager.getAsString("fileupload.path");
        for (int i=0; i< images.length; i++) {
        	if (images[i] != null && !"".equals(images[i])) {
				String imageUrl = imageService.processImage(filePath, images[i]);
				Image image = new Image();
				image.setProduct(addedProduct);
				image.setUrl(imageUrl);
				image.setThumbnail("");
				image.setCreatedDate(new Date());
				commonDao.addImage(image);
        	}
        }
    }

    public int searchTotal(String keyword, long provinceId, long catId) {
        return productDao.searchTotal(keyword, provinceId, catId);
    }

    public List<Product> search(String keyword, int startIndex, int pageSize, long provinceId, long catId) {
        return productDao.search(keyword, startIndex, pageSize, provinceId, catId);
    }

    private String generateFriendlyUrl(String name) {
    	long time = Calendar.getInstance().getTimeInMillis();
    	return name.replace(" ", "-") + "-" + time;
    }
    
    public ProductDAOImpl getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDAOImpl productDao) {
        this.productDao = productDao;
    }

    public CommonDAOImpl getCommonDao() {
        return commonDao;
    }

    public void setCommonDao(CommonDAOImpl commonDao) {
        this.commonDao = commonDao;
    }

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

}
