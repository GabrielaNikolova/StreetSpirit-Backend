package com.app.streetspiritbackend.web;

import com.app.streetspiritbackend.models.viewModels.ProductViewModel;
import com.app.streetspiritbackend.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductViewModel>> getAllProducts() {
        List<ProductViewModel> productViewModels = productService.getAllProducts();

        return ResponseEntity.ok().body(productViewModels);
    }
}
