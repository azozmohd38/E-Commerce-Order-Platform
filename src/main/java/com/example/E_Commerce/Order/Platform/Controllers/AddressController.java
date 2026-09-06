package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.AddressDTO;
import com.example.E_Commerce.Order.Platform.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @PostMapping("add")
    public AddressDTO create(@Valid @RequestBody AddressDTO d) {
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

    @PutMapping("update")
    public AddressDTO update(
            @RequestParam Long id,
            @Valid @RequestBody AddressDTO d) {
        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}