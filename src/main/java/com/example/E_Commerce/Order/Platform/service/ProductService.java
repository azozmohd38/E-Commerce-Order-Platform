package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.ProductDTO;
import com.example.E_Commerce.Order.Platform.entities.Product;
import com.example.E_Commerce.Order.Platform.repositories.OrderItemRepository;
import com.example.E_Commerce.Order.Platform.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements CrudService<ProductDTO> {

    private final ProductRepository repo;

    private final OrderItemRepository orderItemRepository;


    public ProductDTO create(ProductDTO d) {

        Product e = new Product();

        copy(d, e);

        e.setIsActive(true);

        return ProductDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<ProductDTO> getAll() {

        return ProductDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public ProductDTO getById(Long id) {

        return ProductDTO.convertToDTO(
                find(id)
        );
    }


    public ProductDTO update(Long id, ProductDTO d) {

        Product e = find(id);

        copy(d, e);

        return ProductDTO.convertToDTO(
                repo.save(e)
        );
    }


    public void delete(Long id) {

        Product e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }


    Product find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Product"
        );
    }


    private void copy(ProductDTO d, Product e) {

        e.setName(d.getName());

        e.setPrice(d.getPrice());

        e.setStockQuantity(d.getStockQuantity());

        e.setSku(d.getSku());
    }


    public List<ProductDTO> getActiveProductsByCategory(Long categoryId) {

        return ProductDTO.convertToDTO(
                repo.getActiveProductsByCategory(categoryId)
        );
    }


    public List<ProductDTO> getProductsBelowPrice(Double price) {

        return ProductDTO.convertToDTO(
                repo.getProductsBelowPrice(price)
        );
    }


    public List<ProductDTO> getLowStockProducts(Integer threshold) {

        return ProductDTO.convertToDTO(
                repo.getLowStockProducts(threshold)
        );
    }


    public ProductDTO getBestSellingProduct() {

        List<Product> products =
                orderItemRepository.getBestSellingProducts();

        if (products.isEmpty()) {
            return null;
        }

        return ProductDTO.convertToDTO(
                products.get(0)
        );
    }
}