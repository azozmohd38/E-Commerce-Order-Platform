package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("add")
    public CustomerDTO create(@RequestBody CustomerDTO d) {

        return service.create(d);
    }
    @GetMapping("getAll")
    public List<CustomerDTO> getAll() {

        return service.getAll();
    }
    @GetMapping("getById")
    public CustomerDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }

}


