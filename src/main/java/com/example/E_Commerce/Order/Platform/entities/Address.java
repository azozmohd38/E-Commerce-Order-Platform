package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address extends BaseClass {

    private String street;
    private String city;
    private String postalCode;
    private String type;


}
