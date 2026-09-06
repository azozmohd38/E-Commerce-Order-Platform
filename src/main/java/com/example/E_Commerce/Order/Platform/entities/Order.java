package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Order extends BaseClass {

    private Date orderDate;
    private String status;
    private Double totalAmount;

@ManyToOne
    private Customer customer;



}
