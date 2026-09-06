package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Address;
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
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private String postalCode;
    private String type;
    public static AddressDTO convertToDTO(Address address) {

        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .type(address.getType())
                .build();
    }
    public static List<AddressDTO> convertToDTO(List<Address> addresses) {

        return addresses.stream()
                .map(AddressDTO::convertToDTO)
                .collect(Collectors.toList());
    }

}
