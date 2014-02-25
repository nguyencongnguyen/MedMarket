package com.med.market.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;

public class ProductDAOImpl extends HibernateDaoSupport {

	public void add(Product entity) {
	 	getHibernateTemplate().save(entity);
	}

	public Product get(String username) {
		return (Product) getHibernateTemplate().get(Product.class, username);
	}

	public List<Province> getAllProvince() {
        List result = getHibernateTemplate().find(
                "from Province p order by p.name asc");
        return result;
    }

	public List<Category> getAllCategories() {
        List result = getHibernateTemplate().find(
                "from Category c order by c.name asc");
        return result;
    }
}
