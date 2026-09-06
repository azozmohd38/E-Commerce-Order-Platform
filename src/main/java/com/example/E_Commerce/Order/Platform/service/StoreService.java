package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.*;
import com.example.E_Commerce.Order.Platform.entities.*;
import com.example.E_Commerce.Order.Platform.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;


@Service
@RequiredArgsConstructor
@Transactional
public class StoreService implements CrudService<StoreDTO> {



    private final StoreRepository repo;



    public StoreDTO create(StoreDTO d) {
        Store e = new Store();
        copy(d, e);
        return StoreDTO.convertToDTO(repo.save(e));
    }
    public List<StoreDTO> getAll() {
        return StoreDTO.convertToDTO(repo.findAllByIsActiveTrue());
    }
    public StoreDTO getById(Long id) {
        return StoreDTO.convertToDTO(find(id));
    }
    public StoreDTO update(Long id, StoreDTO d) {
        Store e = find(id);
        copy(d, e);
        return StoreDTO.convertToDTO(repo.save(e));

    }


