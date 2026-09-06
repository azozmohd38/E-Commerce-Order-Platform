package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAllByIsActiveTrue();

    Optional<Store> findByIdAndIsActiveTrue(Long id);


    @Query("""
            SELECT COUNT(p)
            FROM Product p
            WHERE p.category.store.id = :storeId
            AND p.isActive = true
            """)
    Long countActiveProductsByStore(
            @Param("storeId") Long storeId
    );


    @Query("""
            SELECT COUNT(c)
            FROM Customer c
            WHERE c.store.id = :storeId
            AND c.isActive = true
            """)
    Long countActiveCustomersByStore(
            @Param("storeId") Long storeId
    );


    @Query("""
            SELECT COUNT(o)
            FROM Order o
            WHERE o.customer.store.id = :storeId
            AND o.isActive = true
            """)
    Long countActiveOrdersByStore(
            @Param("storeId") Long storeId
    );
}