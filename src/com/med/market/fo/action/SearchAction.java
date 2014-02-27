package com.med.market.fo.action;

import java.util.List;

import com.med.market.bll.impl.CommonServiceImpl;
import com.med.market.bll.impl.ProductServiceImpl;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;

public class SearchAction extends AbstractAction {
    private static final int RESULT_PER_PAGE = 20;
    private ProductServiceImpl productService;
    private CommonServiceImpl commonService;
    private long catId;
    private long provinceId;
    private List<Province> provinces;
    private List<Category> categories;
    private List<Product> result;
    private String keyword;
    private int page;
    private int totalPage;
    private int begin;
    private int end;

    public String getSearch() {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }

    public String search() {
        if (keyword == null) {
            keyword = "";
        }
        if (page == 0) {
            page = 1;
        }
        provinces.add(new Province(-1, "Tất cả"));
        categories.add(new Category(-1, "Tất cả"));

        int total = productService.searchTotal(keyword, provinceId, catId);
        totalPage = (total % RESULT_PER_PAGE == 0) ? total/RESULT_PER_PAGE : total/RESULT_PER_PAGE + 1;
        result = productService.search(keyword, (page - 1) * RESULT_PER_PAGE, RESULT_PER_PAGE, provinceId, catId);

        begin = ((page - 7) > 0) ? page - 7 : 1;
        end = ((page + 7) < totalPage) ? page + 7 : totalPage;
        return "success";
    }

    public static String addPageParam(String url) {
        if (url.contains("page=")) {
            url = url.replaceAll("page=\\d+", "");
        }
        return url.contains("?") ? url + "&page=" : url + "?page=";
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
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

    public List<Product> getResult() {
        return result;
    }

    public void setResult(List<Product> result) {
        this.result = result;
    }

}
