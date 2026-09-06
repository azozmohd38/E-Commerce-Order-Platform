package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.CartItemDTO;
import com.example.E_Commerce.Order.Platform.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @PostMapping("add")
    public CartDTO create(@RequestBody CartDTO d) {

        return service.create(d);
    }
    @GetMapping("getAll")
    public List<CartDTO> getAll() {

        return service.getAll();
    }
    @GetMapping("getById")
    public CartDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }
    @PutMapping("update")
    public CartDTO update(
            @RequestParam Long id,
            @RequestBody CartDTO d) {

        return service.update(id, d);
    }
    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }
    @PostMapping("addProduct")
    public CartItemDTO addProductToCart(
            @RequestParam Long cartId,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        return service.addProductToCart(
                cartId,
                productId,
                quantity
        );
    }
    @DeleteMapping("removeItem")
    public void removeItemFromCart(
            @RequestParam Long cartItemId) {

        service.removeItemFromCart(cartItemId);
    }
    @PutMapping("updateQuantity")
    public CartItemDTO updateItemQuantity(
            @RequestParam Long cartItemId,
            @RequestParam Integer quantity) {

        return service.updateItemQuantity(
                cartItemId,
                quantity
        );
    }


}
