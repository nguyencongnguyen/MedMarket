package com.med.market.dao;

import java.util.List;

import com.med.market.dao.model.Product;

public interface ProductDAO {
	public Product addAndLoad(Product entity);
	public Product get(String username);
	public int searchTotal(String keyword, long provinceId, long catId);
	public List<Product> search(String keyword, int startIndex, int pageSize, long provinceId, long catId);
}