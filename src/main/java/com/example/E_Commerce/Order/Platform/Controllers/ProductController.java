package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("add")
    public ProductDTO create(@RequestBody ProductDTO d) {

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



}
