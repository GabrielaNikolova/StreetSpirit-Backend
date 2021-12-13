package com.app.streetspiritbackend.web;


import com.app.streetspiritbackend.models.bindingModels.UserLoginBindModel;
import com.app.streetspiritbackend.models.bindingModels.UserRegistrationBindModel;
import com.app.streetspiritbackend.models.entities.User;
import com.app.streetspiritbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/username")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }


    @PostMapping(path = "/register", consumes = "application/json")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationBindModel user) {

        return userService.registerUser(user);
    }


    @PostMapping(path = "/login", consumes = "application/json")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginBindModel user) {

        return userService.loginUser(user);

    }


//    @PostMapping(path = "/logout")
//    public String logoutUser() {
//
//        return "user was logged out";
//    }

}

