package com.app.streetspiritbackend.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String fullName;
    private String username;
    private String password;
    private Role role;
    private List<Order> orders;

    public User() {
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    @Column(name = "username", unique = true, nullable = true)
    public String getUsername() {
        return username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Order> getOrders() {
        return orders;
    }

//    @ManyToMany(fetch = FetchType.EAGER)
//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public User setRoles(List<Role> roles) {
//        this.roles = roles;
//        return this;
//    }

    @ManyToOne
    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }
}
