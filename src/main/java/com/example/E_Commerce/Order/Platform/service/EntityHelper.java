package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.BaseClass;
import org.springframework.data.jpa.repository.JpaRepository;

public class EntityHelper {

    public static <T extends BaseClass> T active(
            JpaRepository<T, Long> repo,
            Long id,
            String entityName) {

        T entity = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                entityName + " not found"
                        )
                );

        if (!Boolean.TRUE.equals(entity.getIsActive())) {

            throw new RuntimeException(
                    entityName + " is inactive"
            );
        }

        return entity;
    }
}