package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Cart;
import com.example.E_Commerce.Order.Platform.entities.Product;
import com.example.E_Commerce.Order.Platform.repositories.CartItemRepository;
import com.example.E_Commerce.Order.Platform.repositories.CartRepository;
import com.example.E_Commerce.Order.Platform.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class CartService implements CrudService<CartDTO> {

    private final CartRepository repo;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;


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

    private void copy(CartDTO d, Cart e) {

    }
    public CartItemDTO addProductToCart(
            Long cartId,
            Long productId,
            Integer quantity) {


        Cart cart = EntityHelper.active(
                repo,
                cartId,
                "Cart"
        );


        Product product = EntityHelper.active(
                productRepository,
                productId,
                "Product"
        );


}



