package com.example.E_Commerce.Order.Platform.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class StoreDTO {

    private Long id;
    private String name;
    private String location;

    public static StoreDTO convertToDTO(Store store) {

        return StoreDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .location(store.getLocation())
                .build();
    }
}
