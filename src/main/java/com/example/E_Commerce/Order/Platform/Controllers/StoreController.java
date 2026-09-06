package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.dto.StoreDTO;
import com.example.E_Commerce.Order.Platform.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;

    @PostMapping("add")
    public StoreDTO create(
            @Valid @RequestBody StoreDTO d) {

        return service.create(d);
    }

    @GetMapping("getAll")
    public List<StoreDTO> getAll() {

        return service.getAll();
    }

    @GetMapping("getById")
    public StoreDTO getById(
            @RequestParam Long id) {

        return service.getById(id);
    }

    @PutMapping("update")
    public StoreDTO update(
            @RequestParam Long id,
            @Valid @RequestBody StoreDTO d) {

        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(
            @RequestParam Long id) {

        service.delete(id);
    }
}