package com.med.market.dao.model;

public class Category extends Entity {
    private long catId;
    private String name;

    public Category(long catId, String name) {
        this.catId = catId;
        this.name = name;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
