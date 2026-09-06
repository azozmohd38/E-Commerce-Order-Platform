package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

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


}