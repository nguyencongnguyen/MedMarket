package com.med.market.dao.model;

import java.util.Date;

public class Entity implements java.io.Serializable {
	protected Date createdDate;
	protected Date updateDate;
	
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
