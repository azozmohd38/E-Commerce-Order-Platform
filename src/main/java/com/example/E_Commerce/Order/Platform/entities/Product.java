package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Product extends BaseClass {


    private String name;
    private Double price;
    private Integer stockQuantity;
    private String sku;

    @OneToMany
    private Category category;




}
