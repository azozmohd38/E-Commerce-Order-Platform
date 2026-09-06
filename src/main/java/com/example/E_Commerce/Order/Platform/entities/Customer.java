package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
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


}