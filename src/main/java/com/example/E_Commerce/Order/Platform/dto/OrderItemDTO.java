package com.example.E_Commerce.Order.Platform.dto;


import com.example.E_Commerce.Order.Platform.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;
    private Integer quantity;
    private Double unitPrice;

    public static OrderItemDTO convertToDTO(OrderItem orderItem) {

        return OrderItemDTO.builder()
                .id(orderItem.getId())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .build();
    }
    public static List<OrderItemDTO> convertToDTO(List<OrderItem> orderItems) {

        return orderItems.stream()
                .map(OrderItemDTO::convertToDTO)
                .collect(Collectors.toList());
    }



}
