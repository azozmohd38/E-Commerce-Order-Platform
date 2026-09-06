package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.*;
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

 @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;


}
