package com.app.streetspiritbackend.services;

import com.app.streetspiritbackend.models.entities.Role;
import com.app.streetspiritbackend.models.enumModels.RoleEnums;

public interface RoleService {
    void rolesInit();
    Role findByRole(RoleEnums role);
}
