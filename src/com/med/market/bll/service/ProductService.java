package com.med.market.bll.service;

import java.util.List;

import com.med.market.dao.model.Product;
import com.med.market.util.SearchResult;

public interface ProductService {
	public void txAdd(Product product, long catId, long provinceId, String uploadedImages) throws Exception;
	public int searchTotal(String keyword, long provinceId, long catId);
	public List<SearchResult> search(String keyword, int startIndex, int pageSize, long provinceId, long catId);
}
