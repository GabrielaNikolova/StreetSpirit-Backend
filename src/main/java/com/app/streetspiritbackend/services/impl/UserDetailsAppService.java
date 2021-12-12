package com.app.streetspiritbackend.services.impl;

import com.app.streetspiritbackend.models.entities.User;
import com.app.streetspiritbackend.repositories.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsAppService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserDetailsAppService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepo
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " was not found!"));

        return mapToUserDetails(userEntity);
    }


    private UserDetails mapToUserDetails(User userEntity) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getRole().getName().name()));

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorityList
        );
    }
}
