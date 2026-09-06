package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.OrderItemDTO;
import com.example.E_Commerce.Order.Platform.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService service;


    @PostMapping("add")
    public OrderItemDTO create(@RequestBody OrderItemDTO d) {
        return service.create(d);
    }


    @GetMapping("getAll")
    public List<OrderItemDTO> getAll() {
        return service.getAll();
    }


    @GetMapping("getById")
    public OrderItemDTO getById(@RequestParam Long id) {
        return service.getById(id);
    }


    @PutMapping("update")
    public OrderItemDTO update(
            @RequestParam Long id,
            @RequestBody OrderItemDTO d) {

        return service.update(id, d);
    }


    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}