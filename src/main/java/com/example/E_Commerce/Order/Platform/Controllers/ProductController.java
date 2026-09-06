package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.ProductDTO;
import com.example.E_Commerce.Order.Platform.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("add")
    public ProductDTO create(@Valid @RequestBody ProductDTO d) {
        return service.create(d);
    }

    @GetMapping("getAll")
    public List<ProductDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("getById")
    public ProductDTO getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PutMapping("update")
    public ProductDTO update(
            @RequestParam Long id,
            @Valid @RequestBody ProductDTO d) {
        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}