package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Customer;
import com.example.E_Commerce.Order.Platform.entities.OrderItem;
import com.example.E_Commerce.Order.Platform.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByIsActiveTrue();
    Optional<OrderItem> findByIdAndIsActiveTrue(Long id);

    boolean existsByOrderCustomerAndProductAndIsActiveTrue(
            Customer customer,
            Product product
    );
}

