package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartItem")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService service;
    @PostMapping("add")
    public CartItemDTO create(@RequestBody CartItemDTO d) {

        return service.create(d);
    }

}


