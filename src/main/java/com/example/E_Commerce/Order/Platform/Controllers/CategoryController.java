package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.CategoryDTO;
import com.example.E_Commerce.Order.Platform.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("add")
    public CategoryDTO create(@Valid @RequestBody CategoryDTO d) {
        return service.create(d);
    }

    @GetMapping("getAll")
    public List<CategoryDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("getById")
    public CategoryDTO getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PutMapping("update")
    public CategoryDTO update(
            @RequestParam Long id,
            @Valid @RequestBody CategoryDTO d) {
        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}