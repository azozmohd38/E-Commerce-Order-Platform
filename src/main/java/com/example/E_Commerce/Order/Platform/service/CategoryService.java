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
    public CategoryDTO getById(Long id) {
        return CategoryDTO.convertToDTO(find(id));
    }
    public CategoryDTO update(Long id, CategoryDTO d) {
        Category e = find(id);
        copy(d, e);
        return CategoryDTO.convertToDTO(repo.save(e));
    }
    public void delete(Long id) {
        Category e = find(id);
        e.setIsActive(false);
        repo.save(e);
    }
    Category find(Long id) {
        return EntityHelper.active(repo, id, "Category");
    }
    private void copy(CategoryDTO d, Category e) {
        e.setName(d.getName());
        e.setDescription(d.getDescription());
    }
}







