package com.app.streetspiritbackend.repositories;

import com.app.streetspiritbackend.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

   Optional<Product> findByName(String name);

   @Override
   List<Product> findAll();
}
