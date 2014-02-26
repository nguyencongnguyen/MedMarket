package com.med.market.fo.action;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.med.market.bll.impl.AccountServiceImpl;
import com.med.market.bll.impl.ProductServiceImpl;
import com.med.market.dao.model.Account;
import com.med.market.dao.model.Category;
import com.med.market.dao.model.Product;
import com.med.market.dao.model.Province;
import com.med.market.util.ConfigurationManager;

public class ProductAction extends AbstractAction {
    private ProductServiceImpl productService;
    private AccountServiceImpl accountService;
    private String name;
    private String username;
    private String password;
    private String description;
    private long price;
    private long catId;
    private long provinceId;
    private File image;
    private String imageFileName;
    private List<Province> provinces;
    private List<Category> categories;

    public String getProduct() {
        provinces = productService.getAllProvince();
        categories = productService.getAllCategories();
        return "success";
    }

    public String postProduct() throws Exception {
        Account account = accountService.get(username);
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCatId(catId);
        product.setProvinceId(provinceId);

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        String filePath = ConfigurationManager.getAsString("fileupload.path");
        String fileName = generateFileName(imageFileName);
        File fileToCreate = new File(filePath, fileName);
        FileUtils.copyFile(image, fileToCreate);

        productService.add(product, account);
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public AccountServiceImpl getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
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
