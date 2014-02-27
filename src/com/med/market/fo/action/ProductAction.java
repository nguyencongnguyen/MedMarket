package com.med.market.fo.action;

import java.io.File;
import java.util.Calendar;
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
    private long price;
    private long catId;
    private long provinceId;
    private String uploadedImages;
    private List<Province> provinces;
    private List<Category> categories;

    public String getProduct() {
        provinces = commonService.getAllProvince();
        categories = commonService.getAllCategories();
        return "success";
    }

    public String postProduct() throws Exception {
        /*String filePath = ConfigurationManager.getAsString("fileupload.path");
        String fileName = generateFileName(imageFileName);
        File fileToCreate = new File(filePath, fileName);
        FileUtils.copyFile(image, fileToCreate);*/

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setContactName(contactName);
        product.setContactEmail(contactEmail);
        product.setContactPhone(contactPhone);
        product.setContactAddress(contactAddress);
        product.setPassword(password);
        productService.add(product, catId, provinceId);
        return "success";
    }

    private String generateFileName(String fileName) {
        long time = Calendar.getInstance().getTimeInMillis();
        return time + "_" + fileName;
    }

    public ProductServiceImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductServiceImpl productService) {
        this.productService = productService;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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
