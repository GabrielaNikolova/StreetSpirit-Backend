package com.app.streetspiritbackend;

import com.app.streetspiritbackend.services.ProductService;
import com.app.streetspiritbackend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ApplicationDbInit implements CommandLineRunner {
    private final ProductService productService;
    private final RoleService roleService;


    @Autowired
    public ApplicationDbInit(ProductService productService, RoleService roleService) {
        this.productService = productService;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) throws Exception {
        roleService.rolesInit();
        productService.seedProducts();

    }
}
