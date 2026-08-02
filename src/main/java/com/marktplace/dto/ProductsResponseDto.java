package com.marktplace.dto;

import com.marktplace.database.model.Products;

import java.math.BigDecimal;

public class ProductsResponseDto {

    private String name;
    private String category;
    private String description;
    private BigDecimal price;


    public ProductsResponseDto(Builder builder) {
        this.name = builder.name;
        this.category = builder.category;
        this.description = builder.description;
        this.price = builder.price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{

        private String name;
        private String category;
        private String description;
        private BigDecimal price;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder category(String category){
            this.category = category;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder price(BigDecimal price){
            this.price = price;
            return this;
        }

        public ProductsResponseDto build(){
            return new ProductsResponseDto(this);
        }

    }

}
