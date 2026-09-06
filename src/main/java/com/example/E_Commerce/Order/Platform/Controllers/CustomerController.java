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
    @PutMapping("update")
    public CustomerDTO update(
            @RequestParam Long id,
            @RequestBody CustomerDTO d) {

        return service.update(id, d);
    }
    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }
}

}


