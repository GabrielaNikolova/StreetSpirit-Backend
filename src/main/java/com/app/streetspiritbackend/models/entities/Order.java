package com.app.streetspiritbackend.models.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
//    private User user;
    private String deliveryAddress;
    private String phoneNumber;
    private String comments;
    private BigDecimal orderPrice;
    private LocalDateTime createdOn;
    private List<Product> products;

    public Order() {
    }

//    @ManyToOne
//    public User getUser() {
//        return user;
//    }

    @Column(name = "delivery_address", nullable = false)
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Column(name = "comments", nullable = true, columnDefinition = "TEXT")
    public String getComments() {
        return comments;
    }

    @Column(name = "created_on", nullable = false)
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @Column(name = "order_price", nullable = false)
    public BigDecimal getPrice() {
        return orderPrice;
    }

    @ManyToMany
    public List<Product> getProducts() {
        return products;
    }

//    public Order setUser(User user) {
//        this.user = user;
//        return this;
//    }

    public Order setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    public Order setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Order setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Order setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public Order setPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public Order setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}
