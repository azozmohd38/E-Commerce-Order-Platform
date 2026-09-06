package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    private Long id;
    private Integer quantity;

    public static CartItemDTO convertToDTO(CartItem cartItem) {

        return CartItemDTO.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .build();
    }

}

