package com.app.streetspiritbackend.services;

import com.app.streetspiritbackend.models.bindingModels.UserLoginBindModel;
import com.app.streetspiritbackend.models.bindingModels.UserRegistrationBindModel;
import com.app.streetspiritbackend.models.entities.Order;
import com.app.streetspiritbackend.models.entities.User;
import com.app.streetspiritbackend.models.serviceModels.UserRegistrationServModel;

import java.util.List;

public interface UserService {

    void registerAndLoginUser(UserRegistrationBindModel userBindModel);
    void loginUser(UserLoginBindModel userLoginBindModel);

    User getByUsername(String email);

    List<User> getAllUsers();

    void addNewOrder(User user, Order newOrder);

}
