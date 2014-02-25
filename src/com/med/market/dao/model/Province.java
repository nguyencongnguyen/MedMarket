package com.med.market.dao.model;

import java.util.HashSet;
import java.util.Set;

public class Province extends Entity {
	private long provinceId;
	private String name;
	private Set locations = new HashSet(0);
	
	public Province() {
		
	}
	
	public Province(long provinceId, String name) {
		this.provinceId = provinceId;
		this.name = name;
	}
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getLocations() {
		return locations;
	}
	public void setLocations(Set locations) {
		this.locations = locations;
	}
	
}
