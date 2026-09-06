package com.example.E_Commerce.Order.Platform.dto;


import com.example.E_Commerce.Order.Platform.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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



}
