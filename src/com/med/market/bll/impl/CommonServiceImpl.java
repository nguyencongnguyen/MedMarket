package com.med.market.bll.impl;

import java.util.Date;
import java.util.List;

import com.med.market.bll.service.CommonService;
import com.med.market.dao.CommonDAO;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Province;

public class CommonServiceImpl implements CommonService {
	private CommonDAO commonDao;

	public List<Province> getAllProvince() {
		return commonDao.getAllProvince();
	}

	public List<Category> getAllCategories() {
		return commonDao.getAllCategories();
	}

	public CommonDAO getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDAO commonDao) {
		this.commonDao = commonDao;
	}

	public void addImage(Image entity) {
		entity.setCreatedDate(new Date());
		commonDao.addImage(entity);
	}

	public List<Image> getImagesByProductId(long productId) {
		return commonDao.getImagesByProductId(productId);
	}
}
