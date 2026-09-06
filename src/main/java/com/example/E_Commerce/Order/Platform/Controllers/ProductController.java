package com.example.E_Commerce.Order.Platform.controller;

import com.example.E_Commerce.Order.Platform.dto.ProductDTO;
import com.example.E_Commerce.Order.Platform.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PutMapping("update")
    public ProductDTO update(
            @RequestParam Long id,
            @RequestBody ProductDTO d) {

        return service.update(id, d);
    }


    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }


    @GetMapping("getByCategory")
    public List<ProductDTO> getActiveProductsByCategory(
            @RequestParam Long categoryId) {

        return service.getActiveProductsByCategory(categoryId);
    }


    @GetMapping("getBelowPrice")
    public List<ProductDTO> getProductsBelowPrice(
            @RequestParam Double price) {

        return service.getProductsBelowPrice(price);
    }


    @GetMapping("getLowStock")
    public List<ProductDTO> getLowStockProducts(
            @RequestParam Integer threshold) {

        return service.getLowStockProducts(threshold);
    }


    @GetMapping("bestSelling")
    public ProductDTO getBestSellingProduct() {

        return service.getBestSellingProduct();
    }
}