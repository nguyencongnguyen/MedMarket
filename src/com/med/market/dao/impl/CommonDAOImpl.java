package com.med.market.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;

public class CommonDAOImpl extends HibernateDaoSupport {
    public Category getCategory(long catId) {
        return (Category) getHibernateTemplate().get(Category.class, catId);
    }

    public Province getProvince(long provinceId) {
        return (Province) getHibernateTemplate().get(Province.class, provinceId);
    }

    public List<Province> getAllProvince() {
        return getHibernateTemplate().find("from Province p order by p.name asc");
    }

    public List<Category> getAllCategories() {
        return getHibernateTemplate().find("from Category c order by c.name asc");
    }
}
