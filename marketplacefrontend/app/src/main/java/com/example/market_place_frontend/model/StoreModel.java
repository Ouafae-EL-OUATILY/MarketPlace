package com.example.market_place_frontend.model;

import java.util.List;


public class StoreModel {
    private String storeName;
    private List<ProductModel> products;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public StoreModel(String storeName, List<ProductModel> products) {
        this.storeName = storeName;
        this.products = products;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}