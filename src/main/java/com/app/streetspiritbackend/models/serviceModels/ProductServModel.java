package com.app.streetspiritbackend.models.serviceModels;

import com.app.streetspiritbackend.models.enumModels.ProductTypeEnum;

import java.math.BigDecimal;

public class ProductServModel {

    private String id;
    private String name;
    private String description;
    private BigDecimal productPrice;
    private ProductTypeEnum productType;

    public ProductServModel() {
    }

    public String getId() {
        return id;
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

    public ProductServModel setId(String id) {
        this.id = id;
        return this;
    }

    public ProductServModel setName(String name) {
        this.name = name;
        return this;
    }

    public ProductServModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductServModel setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public ProductServModel setProductType(ProductTypeEnum productType) {
        this.productType = productType;
        return this;
    }
}
