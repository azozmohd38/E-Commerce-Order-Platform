package com.example.E_Commerce.Order.Platform.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Shipment extends BaseClass {


    private String trackingNumber;
    private String status;
    private Date shippedDate;



}
