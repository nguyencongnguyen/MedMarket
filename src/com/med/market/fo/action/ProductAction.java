package com.med.market.fo.action;

import java.io.File;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.med.market.bll.impl.CommonServiceImpl;
import com.med.market.bll.impl.ProductServiceImpl;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;
import com.med.market.util.ConfigurationManager;

public class ProductAction extends AbstractAction {
    private ProductServiceImpl productService;
    private CommonServiceImpl commonService;
    private String name;
    private String password;
    private String description;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactAddress;
    private String price;
    private long catId;
    private long provinceId;
    private String uploadedImages;
    private File fileToUpload;
    private String fileToUploadContentType;
    private String fileToUploadFileName;
    private List<Province> provinces;
    private List<Category> categories;
    private LinkedHashMap<String, Object> jsonData = new LinkedHashMap<String, Object>();

    public String getProduct() throws Exception {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }

    public String postProduct() throws Exception {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        if (price != null && !"".equals(price)) {
        	product.setPrice(Long.parseLong(price));
        } else {
        	product.setPrice(new Long(0));
        }
        product.setContactName(contactName);
        product.setContactEmail(contactEmail);
        product.setContactPhone(contactPhone);
        product.setContactAddress(contactAddress);
        product.setPassword(password);
        productService.add(product, catId, provinceId);
        return "success";
    }
    
    public String ajaxUploadImg() throws Exception {
    	String filePath = ConfigurationManager.getAsString("fileupload.path");
        String fileName = generateFileName(fileToUploadFileName);
        File fileToCreate = new File(filePath, fileName);
        FileUtils.copyFile(fileToUpload, fileToCreate);
    	jsonData.put("url", fileToCreate.getName());
    	return "success";
    }

    private String generateFileName(String fileName) {
    	long time = Calendar.getInstance().getTimeInMillis();
    	if (fileName == null) {
    		return time + "";
    	}
    	fileName = fileName.replaceAll("\\s", "");
        if (fileName.length() > 10) {
        	fileName = fileName.substring(0, 9);
        }
        return time + "_" + fileName;
    }

    public ProductServiceImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
    }

    public File getFileToUpload() {
		return fileToUpload;
	}

	public void setFileToUpload(File fileToUpload) {
		this.fileToUpload = fileToUpload;
	}

	public LinkedHashMap<String, Object> getJsonData() {
		return jsonData;
	}

	public String getFileToUploadContentType() {
		return fileToUploadContentType;
	}

	public void setFileToUploadContentType(String fileToUploadContentType) {
		this.fileToUploadContentType = fileToUploadContentType;
	}

	public String getFileToUploadFileName() {
		return fileToUploadFileName;
	}

	public void setFileToUploadFileName(String fileToUploadFileName) {
		this.fileToUploadFileName = fileToUploadFileName;
	}

	public void setJsonData(LinkedHashMap<String, Object> jsonData) {
		this.jsonData = jsonData;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUploadedImages() {
        return uploadedImages;
    }

    public void setUploadedImages(String uploadedImages) {
        this.uploadedImages = uploadedImages;
    }

    public CommonServiceImpl getCommonService() {
        return commonService;
    }

    public void setCommonService(CommonServiceImpl commonService) {
        this.commonService = commonService;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

}
