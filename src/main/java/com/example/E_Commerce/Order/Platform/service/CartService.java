package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Cart;
import com.example.E_Commerce.Order.Platform.repositories.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService implements CrudService<CartDTO> {

    private final CartRepository repo;

    public CartDTO create(CartDTO d) {

        Cart e = new Cart();

        copy(d, e);

        e.setIsActive(true);

        return CartDTO.convertToDTO(repo.save(e));
    }


    public List<CartDTO> getAll() {

        return CartDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public CartDTO getById(Long id) {

        return CartDTO.convertToDTO(
                find(id)
        );
    }


    public CartDTO update(Long id, CartDTO d) {

        Cart e = find(id);

        copy(d, e);

        return CartDTO.convertToDTO(
                repo.save(e)
        );
    }
    public void delete(Long id) {

        Cart e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }

    Cart find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Cart"
        );
    }

}

