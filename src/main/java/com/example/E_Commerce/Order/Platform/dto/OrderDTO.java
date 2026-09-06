package com.example.E_Commerce.Order.Platform.dto;


import com.example.E_Commerce.Order.Platform.entities.Order;
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
public class OrderDTO {

    private Long id;
    private Date orderDate;
    private String status;
    private Double totalAmount;

    public static OrderDTO convertToDTO(Order order) {

        return OrderDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .build();
    }
    public static List<OrderDTO> convertToDTO(List<Order> orders) {

        return orders.stream()
                .map(OrderDTO::convertToDTO)
                .collect(Collectors.toList());
    }

}
