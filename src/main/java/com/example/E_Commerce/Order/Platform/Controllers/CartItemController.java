package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.CartItemDTO;
import com.example.E_Commerce.Order.Platform.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartItem")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService service;


    @PostMapping("add")
    public CartItemDTO create(@RequestBody CartItemDTO d) {

        return service.create(d);
    }


    @GetMapping("getAll")
    public List<CartItemDTO> getAll() {

        return service.getAll();
    }


    @GetMapping("getById")
    public CartItemDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }


    @PutMapping("update")
    public CartItemDTO update(
            @RequestParam Long id,
            @RequestBody CartItemDTO d) {

        return service.update(id, d);
    }


    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }
}