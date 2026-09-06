package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements CrudService<ProductDTO> {

    private final ProductRepository repo;



}
