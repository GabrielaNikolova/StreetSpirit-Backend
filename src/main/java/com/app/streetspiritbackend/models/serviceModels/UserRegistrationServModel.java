package com.app.streetspiritbackend.models.serviceModels;

public class UserRegistrationServModel {
    private String id;
    private String username;
    private String fullName;
    private String password;

    public UserRegistrationServModel() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationServModel setId(String id) {
        this.id = id;
        return this;
    }

    public UserRegistrationServModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserRegistrationServModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserRegistrationServModel setPassword(String password) {
        this.password = password;
        return this;
    }

}
