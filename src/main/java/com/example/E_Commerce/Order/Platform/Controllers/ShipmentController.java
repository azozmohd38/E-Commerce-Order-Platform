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
    @GetMapping("getById")
    public ShipmentDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }
    @PutMapping("update")
    public ShipmentDTO update(
            @RequestParam Long id,
            @RequestBody ShipmentDTO d) {

        return service.update(id, d);
    }
    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }

}

