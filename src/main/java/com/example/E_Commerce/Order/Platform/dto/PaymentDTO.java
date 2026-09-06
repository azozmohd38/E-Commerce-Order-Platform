package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Payment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
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

    @NotNull(message = "Payment amount is required")
    @Positive(message = "Payment amount must be greater than 0")
    private Double amount;

    @NotBlank(message = "Payment method is required")
    private String method;

    @NotBlank(message = "Payment status is required")
    private String status;

    @PastOrPresent(message = "Paid date cannot be in the future")
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