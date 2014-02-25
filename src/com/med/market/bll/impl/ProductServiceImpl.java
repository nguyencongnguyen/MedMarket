package com.med.market.bll.impl;

import java.util.Date;
import java.util.List;

import com.med.market.dao.impl.AccountDAOImpl;
import com.med.market.dao.impl.ProductDAOImpl;
import com.med.market.dao.model.Account;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;

public class ProductServiceImpl {
	private ProductDAOImpl productDao;
	private AccountDAOImpl accountDao;

	public void add(Product product, Account account) {
	    if (accountDao.get(account.getUsername()) == null) {
	        account.setCreatedDate(new Date());
	        accountDao.add(account);
	    }
	    product.setUsername(account.getUsername());
	    product.setCreatedDate(new Date());
	    productDao.add(product);
	}

	public List<Province> getAllProvince() {
	    return productDao.getAllProvince();
	}

	public List<Category> getAllCategories() {
        return productDao.getAllCategories();
    }

	public ProductDAOImpl getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAOImpl ProductDao) {
		this.productDao = productDao;
	}

    public AccountDAOImpl getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDAOImpl accountDao) {
        this.accountDao = accountDao;
    }


}
