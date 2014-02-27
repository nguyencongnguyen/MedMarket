package com.med.market.bll.impl;

import java.util.List;

import com.med.market.dao.impl.CommonDAOImpl;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Province;

public class CommonServiceImpl {
    private CommonDAOImpl commonDao;

    public List<Province> getAllProvince() {
        return commonDao.getAllProvince();
    }

    public List<Category> getAllCategories() {
        return commonDao.getAllCategories();
    }

    public CommonDAOImpl getCommonDao() {
        return commonDao;
    }

    public void setCommonDao(CommonDAOImpl commonDao) {
        this.commonDao = commonDao;
    }

}
