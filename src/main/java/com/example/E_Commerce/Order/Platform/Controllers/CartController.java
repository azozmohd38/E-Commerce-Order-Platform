package com.example.E_Commerce.Order.Platform.Controllers;

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



}
