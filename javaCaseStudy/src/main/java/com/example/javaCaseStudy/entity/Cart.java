package com.example.javaCaseStudy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "prod_id")
    private int productId;
    @Column(name="quantity")
    private int quantity;
    @OneToOne
    @JoinColumn(name = "prod_id")
    private Product product;

    public Cart() {
    }

    public Cart(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
