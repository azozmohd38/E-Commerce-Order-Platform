package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("add")
    public PaymentDTO create(@RequestBody PaymentDTO d) {

        return service.create(d);
    }
    @GetMapping("getAll")
    public List<PaymentDTO> getAll() {

        return service.getAll();
    }
}

