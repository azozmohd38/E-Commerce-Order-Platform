package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByIsActiveTrue();

    Optional<Product> findByIdAndIsActiveTrue(Long id);

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.category.id = :categoryId
            AND p.isActive = true
            """)
    List<Product> getActiveProductsByCategory(
            @Param("categoryId") Long categoryId
    );

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.price < :price
            AND p.isActive = true
            """)
    List<Product> getProductsBelowPrice(
            @Param("price") Double price
    );

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.stockQuantity < :threshold
            AND p.isActive = true
            """)
    List<Product> getLowStockProducts(
            @Param("threshold") Integer threshold
    );
}