package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Review extends BaseClass{

    private Integer rating;
    private String comment;
    private Date reviewDate;

@ManyToOne
private Customer customer;

    public Review() {

    }
}