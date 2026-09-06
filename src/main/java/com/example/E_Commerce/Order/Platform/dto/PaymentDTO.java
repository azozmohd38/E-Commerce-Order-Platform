package com.example.E_Commerce.Order.Platform.dto;


import com.example.E_Commerce.Order.Platform.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private Long id;
    private Double amount;
    private String method;
    private String status;
    private Date paidDate;

    public static PaymentDTO convertToDTO(Payment payment) {

        return PaymentDTO.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .method(payment.getMethod())
                .status(payment.getStatus())
                .paidDate(payment.getPaidDate())
                .build();
    }
    public static List<PaymentDTO> convertToDTO(List<Payment> payments) {

        return payments.stream()
                .map(PaymentDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}


