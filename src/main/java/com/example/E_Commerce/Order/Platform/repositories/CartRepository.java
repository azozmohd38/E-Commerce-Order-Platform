package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Cart;
import com.example.E_Commerce.Order.Platform.entities.CartItem;
import com.example.E_Commerce.Order.Platform.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByIsActiveTrue();

    Optional<Cart> findByIdAndIsActiveTrue(Long id);

    Optional<CartItem> findByCartAndProductAndIsActiveTrue(
            Cart cart,
            Product product
    );
}