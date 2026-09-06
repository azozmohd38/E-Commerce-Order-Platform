package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}