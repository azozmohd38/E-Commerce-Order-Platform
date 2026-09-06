package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByIsActiveTrue();

    Optional<Order> findByIdAndIsActiveTrue(Long id);


    @Query("""
            SELECT o
            FROM Order o
            WHERE o.customer.id = :customerId
            AND o.isActive = true
            """)
    List<Order> getOrdersByCustomer(
            @Param("customerId") Long customerId
    );


    @Query("""
            SELECT COALESCE(SUM(o.totalAmount), 0)
            FROM Order o
            WHERE o.customer.id = :customerId
            AND o.isActive = true
            """)
    Double getTotalSpentByCustomer(
            @Param("customerId") Long customerId
    );
}
