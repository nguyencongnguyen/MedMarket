package com.med.market.bll.impl;

import com.med.market.dao.impl.ProductDAOImpl;

public class ProductServiceImpl {
	private ProductDAOImpl productDao;

	public ProductDAOImpl getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAOImpl ProductDao) {
		this.productDao = productDao;
	}
	
	
}
