package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;

@Entity
@Getter
@Setter

public class Customer extends BaseClass {

    private String name;
    private String email;
    private String phoneNumber;
    private String gender;

@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> reviews;






}