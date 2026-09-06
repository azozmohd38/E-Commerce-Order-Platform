package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {


    List<Payment> findAllByIsActiveTrue();
    Optional<Payment> findByIdAndIsActiveTrue(Long id);

}

