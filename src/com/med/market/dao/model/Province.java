package com.med.market.dao.model;


public class Province extends Entity {
    private long provinceId;
    private String name;

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

}
