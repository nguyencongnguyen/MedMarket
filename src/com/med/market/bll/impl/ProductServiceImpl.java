package com.med.market.bll.impl;

import java.util.Date;
import java.util.List;

import com.med.market.dao.impl.CommonDAOImpl;
import com.med.market.dao.impl.ProductDAOImpl;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;

public class ProductServiceImpl {
    private ProductDAOImpl productDao;
    private CommonDAOImpl commonDao;

    public void add(Product product, long catId, long provinceId) {
        Category cat = commonDao.getCategory(catId);
        Province province = commonDao.getProvince(provinceId);
        product.setCategory(cat);
        product.setProvince(province);
        product.setCreatedDate(new Date());
        productDao.add(product);
    }

    public int searchTotal(String keyword, long provinceId, long catId) {
        return productDao.searchTotal(keyword, provinceId, catId);
    }

    public List<Product> search(String keyword, int startIndex, int pageSize, long provinceId, long catId) {
        return productDao.search(keyword, startIndex, pageSize, provinceId, catId);
    }

    public ProductDAOImpl getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDAOImpl ProductDao) {
        this.productDao = productDao;
    }

    public CommonDAOImpl getCommonDao() {
        return commonDao;
    }

    public void setCommonDao(CommonDAOImpl commonDao) {
        this.commonDao = commonDao;
    }

}
