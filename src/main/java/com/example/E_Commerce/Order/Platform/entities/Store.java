package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jdk.jfr.Category;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Setter

public class Store extends BaseClass {

      private String name;
      private String location;


@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
private List<Product> products;


@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Category> categories;

@OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Customer> customers;









}
