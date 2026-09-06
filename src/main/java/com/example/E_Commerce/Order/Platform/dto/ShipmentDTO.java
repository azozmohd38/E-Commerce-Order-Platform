package com.example.E_Commerce.Order.Platform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDTO {

    private Long id;
    private String trackingNumber;
    private String status;
    private Date shippedDate;

}
