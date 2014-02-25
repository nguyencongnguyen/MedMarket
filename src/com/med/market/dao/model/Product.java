package com.med.market.dao.model;


public class Product extends Entity {
	private long productId;
	private String name;
	private String description;
	private long price;
	private long catId;
	private long accountId;
	private long provinceId;
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public long getProvinceId() {
        return provinceId;
    }
    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

}
