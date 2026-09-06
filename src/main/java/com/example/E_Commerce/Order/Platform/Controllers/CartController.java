package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;



}
