package com.example.E_Commerce.Order.Platform.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


}
