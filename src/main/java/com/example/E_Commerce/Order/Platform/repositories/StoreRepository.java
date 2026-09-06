package com.example.E_Commerce.Order.Platform.repositories;


import com.example.E_Commerce.Order.Platform.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAllByIsActiveTrue();







}
