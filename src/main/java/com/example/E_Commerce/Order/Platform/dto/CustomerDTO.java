package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Customer;
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
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;

    public static CustomerDTO convertToDTO(Customer customer) {

        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .gender(customer.getGender())
                .build();
    }
    public static List<CustomerDTO> convertToDTO(List<Customer> customers) {

        return customers.stream()
                .map(CustomerDTO::convertToDTO)
                .collect(Collectors.toList());
    }


}


