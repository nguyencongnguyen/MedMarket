package com.med.market.dao;

import java.util.List;

import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Province;

public interface CommonDAO {
	public Category getCategory(long catId);

	public Province getProvince(long provinceId);

	public List<Province> getAllProvince();

	public List<Category> getAllCategories();

	public void addImage(Image entity);
	
	public void updateImage(Image entity);
	
	public List<Image> getImagesByProductId(long productId);
	
	public void deleteImage(Image image);
	
	public void deleteImageByProductId(long productId);
}
