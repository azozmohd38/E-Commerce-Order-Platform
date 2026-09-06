package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;
    @PostMapping("add")
    public AddressDTO create(@RequestBody AddressDTO d) {

        return service.create(d);
    }
    @GetMapping("getAll")
    public List<AddressDTO> getAll() {

        return service.getAll();

    }
    @GetMapping("getById")
    public AddressDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }


}
