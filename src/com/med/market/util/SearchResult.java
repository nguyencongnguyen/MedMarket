package com.med.market.util;

import com.med.market.dao.model.Product;


public class SearchResult {
	private long productId;
    private String name;
    private String friendlyUrl;
    private String description;
    private String password;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String contactAddress;
    private long price;
    private String categoryName;
    private String provinceName;
	private String defaultThumnbail;

	public SearchResult() {
		
	}
	public SearchResult(Product product, String defaultThumnbail) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.friendlyUrl = product.getFriendlyUrl();
		this.description = product.getDescription();
		this.password = product.getPassword();
		this.categoryName = product.getCategory().getName();
		this.provinceName = product.getProvince().getName();
		this.contactAddress = product.getContactAddress();
		this.contactEmail = product.getContactEmail();
		this.contactName = product.getContactName();
		this.contactPhone = product.getContactPhone();
		this.price = product.getPrice();
		this.defaultThumnbail = defaultThumnbail;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFriendlyUrl() {
		return friendlyUrl;
	}
	public void setFriendlyUrl(String friendlyUrl) {
		this.friendlyUrl = friendlyUrl;
	}
	public String getDescription() {
		if (description.length() > 150) {
			int idx = description.indexOf(" ", 130);
			return description.substring(0, idx) + "...";
		}
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getDefaultThumnbail() {
		return defaultThumnbail;
	}
	public void setDefaultThumnbail(String defaultThumnbail) {
		this.defaultThumnbail = defaultThumnbail;
	}
}