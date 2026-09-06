package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.CartItem;
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
public class CartItemDTO {

    private Long id;
    private Integer quantity;

    public static CartItemDTO convertToDTO(CartItem cartItem) {

        return CartItemDTO.builder()
                .id(cartItem.getId())
                .quantity(cartItem.getQuantity())
                .build();
    }
    public static List<CartItemDTO> convertToDTO(List<CartItem> cartItems) {

        return cartItems.stream()
                .map(CartItemDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}

}

