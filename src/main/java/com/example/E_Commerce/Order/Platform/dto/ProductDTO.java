package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer stockQuantity;
    private String sku;

    public static ProductDTO convertToDTO(Product product) {

        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .sku(product.getSku())
                .build();
    }
}

