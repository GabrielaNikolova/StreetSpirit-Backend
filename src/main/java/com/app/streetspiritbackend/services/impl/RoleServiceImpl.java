package com.app.streetspiritbackend.services.impl;

import com.app.streetspiritbackend.models.entities.Role;
import com.app.streetspiritbackend.models.enumModels.RoleEnums;
import com.app.streetspiritbackend.repositories.RoleRepo;
import com.app.streetspiritbackend.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }


    @Override
    public void rolesInit() {
        if (roleRepo.count() == 0) {
            roleRepo.saveAll(Arrays.stream(RoleEnums.values())
                    .map(r -> {
                        Role role = new Role();
                        role.setName(r);
                        return role;
                    }).collect(Collectors.toList()));
        }
    }

    @Override
    public Role findByRole(RoleEnums role) {
        return roleRepo.findByName(role)
                .orElseThrow(() -> new IllegalStateException(role + " role not found. Please seed the roles."));
    }
}
