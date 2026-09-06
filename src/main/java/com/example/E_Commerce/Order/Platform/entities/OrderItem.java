package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class OrderItem extends BaseClass{

    private Integer quantity;
    private Double unitPrice;




}
