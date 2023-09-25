package com.example.javaCaseStudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
//    auto_increment column
    private int orderId;
    @Column
    private String username;
    @Column
    private String email;
    @Column(name = "shipping_address")
    private String address;
    @Column(name = "total_amt")
    private double totalAmount;

    public Orders() {
    }

    public Orders(int orderId, String username, String email, String address, double totalAmount) {
        this.orderId = orderId;
        this.username = username;
        this.email = email;
        this.address = address;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
