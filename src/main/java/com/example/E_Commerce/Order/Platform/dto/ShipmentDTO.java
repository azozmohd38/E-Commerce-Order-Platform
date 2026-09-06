package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Shipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDTO {

    private Long id;
    private String trackingNumber;
    private String status;
    private Date shippedDate;

    public static ShipmentDTO convertToDTO(Shipment shipment) {

        return ShipmentDTO.builder()
                .id(shipment.getId())
                .trackingNumber(shipment.getTrackingNumber())
                .status(shipment.getStatus())
                .shippedDate(shipment.getShippedDate())
                .build();
    }
    public static List<ShipmentDTO> convertToDTO(List<Shipment> shipments) {

        return shipments.stream()
                .map(ShipmentDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}
