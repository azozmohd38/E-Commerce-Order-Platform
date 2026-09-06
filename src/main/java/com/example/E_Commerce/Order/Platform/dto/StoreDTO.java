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

}
