package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.*;
import com.example.E_Commerce.Order.Platform.entities.*;
import com.example.E_Commerce.Order.Platform.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


// Git Commit: Create CategoryService
@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService implements CrudService<CategoryDTO> {



    private final CategoryRepository repo;

    public CategoryDTO create(CategoryDTO d) {
        Category e = new Category();
        copy(d, e);
        return CategoryDTO.convertToDTO(repo.save(e));
    }
    public List<CategoryDTO> getAll() {
        return CategoryDTO.convertToDTO(repo.findAllByIsActiveTrue());
    }




