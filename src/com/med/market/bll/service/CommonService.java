package com.med.market.bll.service;

import java.util.List;

import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Province;

public interface CommonService {
	public List<Province> getAllProvince();

	public List<Category> getAllCategories();

	public void addImage(Image entity);
	
	public List<Image> getImagesByProductId(long productId);
}
