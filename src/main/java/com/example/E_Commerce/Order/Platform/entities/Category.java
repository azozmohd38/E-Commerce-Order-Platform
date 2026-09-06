package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter


public class Category extends BaseClass {

     private String name;
     private String description;


@OneToMany
  private Store store;

@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;




}
