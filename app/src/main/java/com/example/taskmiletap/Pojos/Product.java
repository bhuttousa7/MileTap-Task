package com.example.taskmiletap.Pojos;

public class Product {
    int id;
    String productName, productCategory , description;
    int availableStock, imgUrl;

    public Product(int id, String productName, String productCategory, int imgUrl, String description, int availableStock) {
        this.id = id;
        this.productName = productName;
        this.productCategory = productCategory;
        this.imgUrl = imgUrl;
        this.description = description;
        this.availableStock = availableStock;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }


}
