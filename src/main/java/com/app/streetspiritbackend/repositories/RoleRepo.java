package com.app.streetspiritbackend.repositories;

import com.app.streetspiritbackend.models.entities.Role;
import com.app.streetspiritbackend.models.enumModels.RoleEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnums role);
}
