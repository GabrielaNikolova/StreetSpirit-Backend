package com.app.streetspiritbackend.models.bindingModels;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginBindModel {
    private String username;
    private String password;

    public UserLoginBindModel() {
    }

    @NotBlank(message = "Must be a valid email.")
    @Email(message = "Must be a valid email.")
    public String getUsername() {
        return username;
    }

    @NotEmpty
    @Size(min = 5, max = 20)
    public String getPassword() {
        return password;
    }

    public UserLoginBindModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserLoginBindModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
