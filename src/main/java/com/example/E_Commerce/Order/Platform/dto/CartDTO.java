package com.example.E_Commerce.Order.Platform.dto;


import com.example.E_Commerce.Order.Platform.entities.Cart;
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
public class CartDTO {


    private Long id;


public static CartDTO convertToDTO(Cart cart) {

    return CartDTO.builder()
            .id(cart.getId())
            .build();
}
    public static List<CartDTO> convertToDTO(List<Cart> carts) {

        return carts.stream()
                .map(CartDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}

