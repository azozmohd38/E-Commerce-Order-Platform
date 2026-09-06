package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Cart extends BaseClass {

@ManyToOne
    private Customer customer;

}
