package com.med.market.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.model.Product;

public class ProductDAOImpl extends HibernateDaoSupport {

	public void add(Product entity) {
	 	getHibernateTemplate().save(entity);
	}

	public Product get(String username) {
		return (Product) getHibernateTemplate().get(Product.class, username);
	}

	public int searchTotal(String keyword, long provinceId, long catId) {
        String provinceQuery = (provinceId >= 0) ? " and p.province.provinceId=" + provinceId : "";
        String catQuery = (catId >= 0) ? " and p.category.catId=" + catId : "";
        String queryString = "from Product p where (p.name like '%" + keyword + "%' or p.description like '%" + keyword + "%')" + provinceQuery + catQuery;
        if (keyword != null && "".equals(keyword)) {
            queryString = "from Product l where 1=1" + provinceQuery + catQuery;
        }
        return getHibernateTemplate().find(queryString).size();
    }

    public List<Product> search(String keyword, int startIndex, int pageSize, long provinceId, long catId) {
        String provinceQuery = (provinceId >= 0) ? " and p.province.provinceId=" + provinceId : "";
        String catQuery = (catId >= 0) ? " and p.category.catId=" + catId : "";
        String queryString = "from Product p where (p.name like '%" + keyword + "%' or p.description like '%" + keyword + "%')" + provinceQuery + catQuery;
        if (keyword != null && "".equals(keyword)) {
            queryString = "from Product l where 1=1" + provinceQuery + catQuery;
        }
        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        return (List<Product>) query.list();
    }
}
