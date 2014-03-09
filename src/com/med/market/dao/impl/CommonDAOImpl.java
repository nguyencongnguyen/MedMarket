package com.med.market.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.CommonDAO;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Image;
import com.med.market.dao.model.Province;

public class CommonDAOImpl extends HibernateDaoSupport implements CommonDAO {
    public Category getCategory(long catId) {
        return (Category) getHibernateTemplate().get(Category.class, catId);
    }

    public Province getProvince(long provinceId) {
        return (Province) getHibernateTemplate().get(Province.class, provinceId);
    }

    public List<Province> getAllProvince() {
        return getHibernateTemplate().find("from Province p order by p.provinceId asc");
    }

    public List<Category> getAllCategories() {
        return getHibernateTemplate().find("from Category c order by c.name asc");
    }
    
    public void addImage(Image entity) {
	 	getHibernateTemplate().save(entity);
	}
    
    public List<Image> getImagesByProductId(long productId) {
    	return getHibernateTemplate().find("from Image i where i.product.productId = " + productId + " order by i.imgId asc");
    }

	public void deleteImage(Image image) {
		getHibernateTemplate().delete(image);
	}
	
	public void deleteImageByProductId(long productId) {
		String queryString = "delete from Image i where i.product.productId=:id";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setParameter("id", productId);
		query.executeUpdate();
	}
}
