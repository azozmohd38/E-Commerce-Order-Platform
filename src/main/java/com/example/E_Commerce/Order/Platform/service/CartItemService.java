package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.repositories.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class CartItemService implements CrudService<CartItemDTO> {

    private final CartItemRepository repo;

    public CartItemDTO create(CartItemDTO d) {

        CartItem e = new CartItem();

        copy(d, e);

        e.setIsActive(true);

        return CartItemDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<CartItemDTO> getAll() {

        return CartItemDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public CartItemDTO getById(Long id) {

        return CartItemDTO.convertToDTO(
                find(id)
        );
    }


    public CartItemDTO update(Long id, CartItemDTO d) {

        CartItem e = find(id);

        copy(d, e);

        return CartItemDTO.convertToDTO(
                repo.save(e)
        );
    }

}

