package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import lombok.Setter;

@Entity
@Setter
@Setter

public class Store extends BaseClass {

      private String name;
      private String location;


}
