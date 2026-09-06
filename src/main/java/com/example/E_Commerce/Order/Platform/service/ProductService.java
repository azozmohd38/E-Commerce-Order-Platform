package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Product;
import com.example.E_Commerce.Order.Platform.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements CrudService<ProductDTO> {

    private final ProductRepository repo;

    public ProductDTO create(ProductDTO d) {
        Product e = new Product();
        copy(d, e);
        return ProductDTO.convertToDTO(repo.save(e));
    }
    public List<ProductDTO> getAll() {
        return ProductDTO.convertToDTO(repo.findAllByIsActiveTrue());
    }
    public ProductDTO getById(Long id) {
        return ProductDTO.convertToDTO(find(id));
    }

}
