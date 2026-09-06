package com.example.E_Commerce.Order.Platform.controller;

import com.example.E_Commerce.Order.Platform.dto.StoreDTO;
import com.example.E_Commerce.Order.Platform.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService service;


    @PostMapping("add")
    public StoreDTO create(@RequestBody StoreDTO d) {

        return service.create(d);
    }


    @GetMapping("getAll")
    public List<StoreDTO> getAll() {

        return service.getAll();
    }


    @GetMapping("getById")
    public StoreDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }


    @PutMapping("update")
    public StoreDTO update(
            @RequestParam Long id,
            @RequestBody StoreDTO d) {

        return service.update(id, d);
    }


    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }


    @GetMapping("stats")
    public Map<String, Long> getStoreStats(
            @RequestParam Long storeId) {

        return service.getStoreStats(storeId);
    }
}
