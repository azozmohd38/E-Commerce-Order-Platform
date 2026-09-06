package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.PaymentDTO;
import com.example.E_Commerce.Order.Platform.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping("add")
    public PaymentDTO create(@Valid @RequestBody PaymentDTO d) {
        return service.create(d);
    }

    @GetMapping("getAll")
    public List<PaymentDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("getById")
    public PaymentDTO getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PutMapping("update")
    public PaymentDTO update(
            @RequestParam Long id,
            @Valid @RequestBody PaymentDTO d) {
        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}