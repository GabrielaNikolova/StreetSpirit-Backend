package com.app.streetspiritbackend.services;

import com.app.streetspiritbackend.models.bindingModels.UserLoginBindModel;
import com.app.streetspiritbackend.models.bindingModels.UserRegistrationBindModel;
import com.app.streetspiritbackend.models.entities.Order;
import com.app.streetspiritbackend.models.entities.User;
import com.app.streetspiritbackend.models.serviceModels.UserRegistrationServModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<String> registerUser(UserRegistrationBindModel userBindModel);
    ResponseEntity<String> loginUser(UserLoginBindModel userLoginBindModel);

    User getByUsername(String email);

    List<User> getAllUsers();

    void addNewOrder(User user, Order newOrder);

}
