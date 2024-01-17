package com.example.market_place_frontend.model;

import android.net.Uri;

public class ProductModel {
    private String productName;
    private String productPrice;
    private String imageUrl;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public ProductModel(String productName, String productPrice, String imageUrl) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
    }

    public Uri getImageUrl() {
        return Uri.parse(this.imageUrl);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}

