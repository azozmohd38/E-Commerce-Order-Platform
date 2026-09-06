package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.OrderDTO;
import com.example.E_Commerce.Order.Platform.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("add")
    public OrderDTO create(@Valid @RequestBody OrderDTO d) {
        return service.create(d);
    }

    @GetMapping("getAll")
    public List<OrderDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("getById")
    public OrderDTO getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @PutMapping("update")
    public OrderDTO update(
            @RequestParam Long id,
            @Valid @RequestBody OrderDTO d) {
        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}