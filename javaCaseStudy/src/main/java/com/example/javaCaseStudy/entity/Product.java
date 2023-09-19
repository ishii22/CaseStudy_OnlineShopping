package com.example.javaCaseStudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products1")
public class Product {
    @Id
    @Column(name = "prod_id")
    private int productId;
    @Column(name = "prod_name")
    private String productName;
    @Column(name = "prod_desc")
    private String productDesc;
    @Column(name = "prod_price")
    private double productPrice;
    @Column(name = "prod_category")
    private String productCategory;
    @Column(name = "prod_rating")
    private double productRating;

    public Product() {
    }

    public Product(int productId, String productName,String productDesc, double productPrice, String productCategory, double productRating) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc=productDesc;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productRating = productRating;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getProductRating() {
        return productRating;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }
}
