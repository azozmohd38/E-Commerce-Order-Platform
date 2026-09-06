package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Store;
import com.example.E_Commerce.Order.Platform.repositories.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService implements CrudService<StoreDTO> {

    private final StoreRepository repo;

    @Override
    public StoreDTO create(StoreDTO d) {
        Store e = new Store();
        copy(d, e);
        e.setIsActive(true);
        return StoreDTO.convertToDTO(repo.save(e));


    }



}
