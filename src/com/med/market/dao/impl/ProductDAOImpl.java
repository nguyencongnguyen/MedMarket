package com.med.market.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.model.Product;

public class ProductDAOImpl extends HibernateDaoSupport {

	public void add(Product entity) {
	 	getHibernateTemplate().save(entity);
	}

	public Product get(String username) {
		return (Product) getHibernateTemplate().get(Product.class, username);
	}
	
}
