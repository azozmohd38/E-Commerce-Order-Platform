package com.example.E_Commerce.Order.Platform.repositories;

import com.example.E_Commerce.Order.Platform.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByIsActiveTrue();
    Optional<Category> findByIdAndIsActiveTrue(Long id);




}