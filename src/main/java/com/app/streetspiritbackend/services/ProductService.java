package com.app.streetspiritbackend.services;


import com.app.streetspiritbackend.models.entities.Product;
import com.app.streetspiritbackend.models.viewModels.ProductViewModel;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;
    Product getProductByName(String name);
    List<ProductViewModel> getAllProducts();
}
