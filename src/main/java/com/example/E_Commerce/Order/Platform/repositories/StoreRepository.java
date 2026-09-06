package com.example.E_Commerce.Order.Platform.repositories;


import com.example.E_Commerce.Order.Platform.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAllByIsActiveTrue();
    Optional<Store> findByIdAndIsActiveTrue(Long id);








}
