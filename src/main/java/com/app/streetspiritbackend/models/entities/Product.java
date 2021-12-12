package com.app.streetspiritbackend.models.entities;


import com.app.streetspiritbackend.models.enumModels.ProductTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    private String name;
    private String description;
    private BigDecimal productPrice;
    private ProductTypeEnum productType;

    public Product() {
    }


    @Column(name = "product_name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "product_description", nullable = true, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column(name = "product_price", nullable = false)
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    public ProductTypeEnum getProductType() {
        return productType;
    }


    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public Product setProductType(ProductTypeEnum productType) {
        this.productType = productType;
        return this;
    }

}
