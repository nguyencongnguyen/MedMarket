package com.med.market.bll.service;

import java.util.List;

import com.med.market.dao.model.Product;
import com.med.market.util.CrossSellProduct;
import com.med.market.util.SearchResult;

public interface ProductService {
	public void txAdd(Product product, long catId, long provinceId, String uploadedImages) throws Exception;
	public int searchTotal(String keyword, long provinceId, long catId);
	public List<SearchResult> search(String keyword, int startIndex, int pageSize, long provinceId, long catId);
	public Product getByUrl(String url);
	public Product get(long id);
	public List<CrossSellProduct> findSimilar(long productId, long catId, int num);
	public void delete(Product product);
}
