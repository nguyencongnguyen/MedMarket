package com.med.market.fo.action;

import java.util.LinkedHashMap;
import java.util.List;

import com.med.market.bll.service.CommonService;
import com.med.market.bll.service.ProductService;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;

public class AdminAction extends AbstractAction {
    private ProductService productService;
    private CommonService commonService;
    private long catId;
    private long provinceId;
    private String productId;
    private String approve;
    private List<Province> provinces;
    private List<Category> categories;
    private List<Product> result;
    private LinkedHashMap<String, Object> jsonData = new LinkedHashMap<String, Object>();
    
    public String listProduct() {
    	result = productService.txGetUnApprovedProducts();
        return "success";
    }
    
    public String approve() throws Exception {
    	if (productId != null) {
    		Product prod = productService.get(new Long(productId));
    		if ("no".equals(approve)) {
    			productService.delete(prod);
    		} else {
    			prod.setApprove(true);
    			productService.txApprove(prod);
    		}
    	}
    	return "success";
    }
    
    public String commonError() throws Exception {
		return "error";
	}

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public CommonService getCommonService() {
        return commonService;
    }

    public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public LinkedHashMap<String, Object> getJsonData() {
		return jsonData;
	}

	public void setJsonData(LinkedHashMap<String, Object> jsonData) {
		this.jsonData = jsonData;
	}

	public List<Product> getResult() {
		return result;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setResult(List<Product> result) {
		this.result = result;
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

}
