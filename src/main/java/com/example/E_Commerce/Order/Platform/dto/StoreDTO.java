package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Store;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
    public static List<StoreDTO> convertToDTO(List<Store> stores) {

        return stores.stream()
                .map(StoreDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}
