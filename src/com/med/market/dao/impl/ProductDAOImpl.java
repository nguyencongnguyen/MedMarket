package com.med.market.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.ProductDAO;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Product;

public class ProductDAOImpl extends HibernateDaoSupport implements ProductDAO {

	public Product addAndLoad(Product entity) {
	 	return (Product) getHibernateTemplate().get(Product.class, (Long) getHibernateTemplate().save(entity));
	}

	public void update(Product entity) {
		getHibernateTemplate().update(entity);
	}
	
	public Product get(long productId) {
		return (Product) getHibernateTemplate().get(Product.class, productId);
	}
	
	public Product getByUrl(String url) {
		return (Product) getHibernateTemplate().find("from Product p where p.approve=1 and p.friendlyUrl = '" + url +"'").get(0);
	}

	public List<Product> findSimilar(long catId, int num) {
		String queryString = "from Product p where p.approve=1 and p.category.catId=:catId order by RAND()";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setParameter("catId", catId);
		query.setFirstResult(0);
		query.setMaxResults(num);
		return (List<Product>) query.list();
	}
	
	public int searchTotal(String keyword, long provinceId, long catId) {
        String queryString = buildSearch(keyword, provinceId, catId);
        return getHibernateTemplate().find(queryString).size();
    }

	public void delete(Product product) {
		getHibernateTemplate().delete(product);
	}
	
	private String buildSearch(String keyword, long provinceId, long catId) {
		String provinceQuery = (provinceId >= 0) ? " and p.province.provinceId=" + provinceId : "";
        String catQuery = (catId >= 0) ? " and p.category.catId=" + catId : "";
        String queryString = "from Product p where p.approve=1 and (p.name like '%" + keyword + "%' or p.description like '%" + keyword + "%')" + provinceQuery + catQuery;
        if (keyword == null || "".equals(keyword)) {
            queryString = "from Product p where p.approve=1 and 1=1" + provinceQuery + catQuery;
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
    
    public List<Product> getUnApprovedProducts() {
    	String queryString = "from Product p where p.approve=0 order by p.createdDate asc";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
		return (List<Product>) query.list();
	}
}
