package com.app.streetspiritbackend.services.impl;

import com.app.streetspiritbackend.models.bindingModels.ProductBindModel;
import com.app.streetspiritbackend.models.entities.Product;
import com.app.streetspiritbackend.models.serviceModels.ProductServModel;
import com.app.streetspiritbackend.models.viewModels.ProductViewModel;
import com.app.streetspiritbackend.repositories.ProductRepo;
import com.app.streetspiritbackend.services.ProductService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private final static String PRODUCTS_PATH = "src/main/resources/static/jsons/products.json";
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public ProductServiceImpl(ProductRepo productRepo, ModelMapper modelMapper, Gson gson) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }


    @Override
    @Transactional
    public void seedProducts() throws IOException {
        //Read JSON
        String content = String.join("", Files.readAllLines(Path.of(PRODUCTS_PATH)));

        // JSON to DTO
        ProductBindModel[] productBindModels = gson.fromJson(content, ProductBindModel[].class); //TODO
        ProductServModel[] productServModels = modelMapper.map(productBindModels, ProductServModel[].class);

        //DTO save to DB

        for (ProductServModel productServModel : productServModels) {
            if (getProductByName(productServModel.getName()) == null) {
                productRepo.save(modelMapper.map(productServModel, Product.class));
            }
        }

    }

    @Override
    public Product getProductByName(String name) {
        return productRepo.findByName(name)
                .orElseThrow(() -> new IllegalStateException(name + " product not found. Please seed the products."));
    }

    @Override
    public List<ProductViewModel> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .map(p -> modelMapper.map(p, ProductViewModel.class))
                .collect(Collectors.toList());
    }

}
