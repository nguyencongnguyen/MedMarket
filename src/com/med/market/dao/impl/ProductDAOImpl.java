package com.med.market.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.ProductDAO;
import com.med.market.dao.model.Product;

public class ProductDAOImpl extends HibernateDaoSupport implements ProductDAO {

	public Product addAndLoad(Product entity) {
	 	return (Product) getHibernateTemplate().get(Product.class, (Long) getHibernateTemplate().save(entity));
	}

	public Product get(long productId) {
		return (Product) getHibernateTemplate().get(Product.class, productId);
	}
	
	public Product getByUrl(String url) {
		return (Product) getHibernateTemplate().find("from Product p where p.friendlyUrl = '" + url +"'").get(0);
	}

	public int searchTotal(String keyword, long provinceId, long catId) {
        String queryString = buildSearch(keyword, provinceId, catId);
        return getHibernateTemplate().find(queryString).size();
    }

	private String buildSearch(String keyword, long provinceId, long catId) {
		String provinceQuery = (provinceId >= 0) ? " and p.province.provinceId=" + provinceId : "";
        String catQuery = (catId >= 0) ? " and p.category.catId=" + catId : "";
        String queryString = "from Product p where (p.name like '%" + keyword + "%' or p.description like '%" + keyword + "%')" + provinceQuery + catQuery;
        if (keyword == null || "".equals(keyword)) {
            queryString = "from Product p where 1=1" + provinceQuery + catQuery;
        }
		return queryString;
	}

    public List<Product> search(String keyword, int startIndex, int pageSize, long provinceId, long catId) {
        String queryString = buildSearch(keyword, provinceId, catId);
        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);
        return (List<Product>) query.list();
    }
}
