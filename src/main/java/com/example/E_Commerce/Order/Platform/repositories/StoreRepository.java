package com.example.E_Commerce.Order.Platform.repositories;


import com.example.E_Commerce.Order.Platform.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {


@Query("SELECT s FROM Store s WHERE s.isActive = true")
List<Store> getAllStores();






}
