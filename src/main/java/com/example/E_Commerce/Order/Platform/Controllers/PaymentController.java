package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;


}

