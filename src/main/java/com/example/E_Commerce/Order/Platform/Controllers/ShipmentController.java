package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shipment")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService service;
    @PostMapping("add")
    public ShipmentDTO create(@RequestBody ShipmentDTO d) {

        return service.create(d);
    }
    @GetMapping("getAll")
    public List<ShipmentDTO> getAll() {

        return service.getAll();
    }

}

