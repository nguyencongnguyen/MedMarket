package com.med.market.util;

import com.med.market.dao.model.Product;

public class CrossSellProduct {
	private long productId;
	private String name;
	private String friendlyUrl;
	private String description;
	private long price;
	private String defaultThumnbail;

	public CrossSellProduct() {

	}

	public CrossSellProduct(Product product, String defaultThumnbail) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.friendlyUrl = product.getFriendlyUrl();
		this.description = product.getDescription();
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

	public String getDefaultThumnbail() {
		return defaultThumnbail;
	}

	public void setDefaultThumnbail(String defaultThumnbail) {
		this.defaultThumnbail = defaultThumnbail;
	}
}