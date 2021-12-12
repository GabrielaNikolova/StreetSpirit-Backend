package com.app.streetspiritbackend.models.viewModels;

import com.app.streetspiritbackend.models.enumModels.ProductTypeEnum;

import java.math.BigDecimal;

public class ProductViewModel {
    private String id;
    private String name;
    private String description;
    private BigDecimal productPrice;
    private ProductTypeEnum productType;

    public ProductViewModel() {
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public ProductTypeEnum getProductType() {
        return productType;
    }

    public ProductViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public ProductViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductViewModel setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public ProductViewModel setProductType(ProductTypeEnum productType) {
        this.productType = productType;
        return this;
    }
}
