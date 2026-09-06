package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping("add")
    public ReviewDTO create(@RequestBody ReviewDTO d) {

        return service.create(d);
    }
    @GetMapping("getAll")
    public List<ReviewDTO> getAll() {

        return service.getAll();
    }
    @GetMapping("getById")
    public ReviewDTO getById(@RequestParam Long id) {

        return service.getById(id);
    }
    @PutMapping("update")
    public ReviewDTO update(
            @RequestParam Long id,
            @RequestBody ReviewDTO d) {

        return service.update(id, d);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam Long id) {

        service.delete(id);
    }


}

