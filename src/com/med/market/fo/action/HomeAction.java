package com.med.market.fo.action;

import java.util.List;

import com.med.market.bll.impl.CommonServiceImpl;
import com.med.market.bll.impl.ProductServiceImpl;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Province;

public class HomeAction extends AbstractAction {
    private ProductServiceImpl productService;
    private CommonServiceImpl commonService;
    private long catId;
    private long provinceId;
    private List<Province> provinces;
    private List<Category> categories;
    private String keyword;

    public String home() {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }

    public String commonError() throws Exception {
		return "error";
	}

    public ProductServiceImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public CommonServiceImpl getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonServiceImpl commonService) {
        this.commonService = commonService;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
