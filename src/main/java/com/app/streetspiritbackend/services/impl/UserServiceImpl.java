package com.app.streetspiritbackend.services.impl;

import com.app.streetspiritbackend.models.bindingModels.UserLoginBindModel;
import com.app.streetspiritbackend.models.bindingModels.UserRegistrationBindModel;
import com.app.streetspiritbackend.models.entities.Order;
import com.app.streetspiritbackend.models.entities.Role;
import com.app.streetspiritbackend.models.entities.User;
import com.app.streetspiritbackend.models.enumModels.RoleEnums;
import com.app.streetspiritbackend.models.serviceModels.UserRegistrationServModel;
import com.app.streetspiritbackend.repositories.UserRepo;
import com.app.streetspiritbackend.services.RoleService;
import com.app.streetspiritbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsAppService userDetailsAppService;


    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, RoleService roleService, PasswordEncoder passwordEncoder, UserDetailsAppService userDetailsAppService) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsAppService = userDetailsAppService;
    }


    @Override
    public ResponseEntity<String> registerUser(UserRegistrationBindModel userBindModel) {
        UserRegistrationServModel userRegistrationServModel = modelMapper.map(userBindModel, UserRegistrationServModel.class);

        if (getByUsername(userRegistrationServModel.getUsername()) != null) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        User newUser = modelMapper.map(userRegistrationServModel, User.class);
        newUser.setPassword(passwordEncoder.encode(userRegistrationServModel.getPassword()));

        Role userRole = roleService.
                findByRole(RoleEnums.USER);
        newUser.setRole(userRole);

        List<Order> userOrders = new ArrayList<>();
        newUser.setOrders(userOrders);
        userRepo.save(newUser);
        return new ResponseEntity<>("User was registered successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> loginUser(UserLoginBindModel user) {
        if (getByUsername(user.getUsername())== null){
            return new ResponseEntity<>("User with email " + user.getUsername() + " not found.", HttpStatus.BAD_REQUEST);
        }

        UserDetails principal = userDetailsAppService.loadUserByUsername(user.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                user.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }


    @Override
    public User getByUsername(String email) {
        return userRepo.findByUsername(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found."));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void addNewOrder(User user, Order newOrder) {
        user.getOrders().add(newOrder);
        userRepo.save(user);
    }
}
