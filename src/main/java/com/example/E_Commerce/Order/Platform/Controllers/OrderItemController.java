package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

RestController
@RequestMapping("orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService service;



}

