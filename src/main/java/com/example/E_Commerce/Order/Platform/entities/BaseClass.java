package com.example.E_Commerce.Order.Platform.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;


}
