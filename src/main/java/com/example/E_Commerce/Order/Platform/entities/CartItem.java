package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class CartItem extends BaseClass {

    private Integer quantity;


@OneToOne
    private Cart cart;

@OneToOne
    private Product product;




}
