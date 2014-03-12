package com.med.market.fo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.med.market.bll.service.CommonService;
import com.med.market.bll.service.ProductService;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Province;

public class HomeAction extends AbstractAction {
    private ProductService productService;
    private long catId;
    private long provinceId;
    private List<Province> provinces;
    private List<Category> categories;
    private String keyword;
    private String username;
    private String password;

    public String home() {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }
    
    public String login() throws Exception {
		return "success";
	}
    
    public String loginSubmit() throws Exception {
    	if (password != null && "beLinh@110".equals(password) && username != null && username.equals("admin")) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute(LoginInterceptor.USER_ACCOUNT, "admin");
			return "success";
		} else {
			return "input";
		}
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

    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
