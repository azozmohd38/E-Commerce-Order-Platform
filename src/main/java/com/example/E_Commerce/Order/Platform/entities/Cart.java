package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Cart extends BaseClass {

@ManyToOne
    private Customer customer;


@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;


}
