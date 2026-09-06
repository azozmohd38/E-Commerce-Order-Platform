package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByIsActiveTrue();
    Optional<Order> findByIdAndIsActiveTrue(Long id);

}
