package com.app.streetspiritbackend.models.bindingModels;

import com.app.streetspiritbackend.models.enumModels.ProductTypeEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductBindModel {
    private String name;
    private String description;
    private BigDecimal productPrice;
    private ProductTypeEnum productType;

    public ProductBindModel() {
    }

    @NotEmpty
    public String getName() {
        return name;
    }

    @NotEmpty
    public String getDescription() {
        return description;
    }

    @DecimalMin("0")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    @NotNull
    public ProductTypeEnum getProductType() {
        return productType;
    }

    public ProductBindModel setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBindModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBindModel setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public ProductBindModel setProductType(ProductTypeEnum productType) {
        this.productType = productType;
        return this;
    }
}
