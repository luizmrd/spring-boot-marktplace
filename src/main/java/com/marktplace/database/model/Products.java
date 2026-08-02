package com.marktplace.database.model;


import com.marktplace.dto.ProductsResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String description;
    private BigDecimal price;


    public Products(Long id, String name, String category, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }


    public Products(){
    }

    private Products(Builder builder) {
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

        public Products build(){
            return new Products(this);
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
