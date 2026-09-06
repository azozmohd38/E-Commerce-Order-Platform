package com.example.E_Commerce.Order.Platform.controller;

import com.example.E_Commerce.Order.Platform.dto.ReviewDTO;
import com.example.E_Commerce.Order.Platform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("submitReview")
    public ReviewDTO submitReview(
            @RequestParam Long customerId,
            @RequestParam Long productId,
            @RequestParam Integer rating,
            @RequestParam String comment) {

        return service.submitReview(
                customerId,
                productId,
                rating,
                comment
        );
    }


    @GetMapping("averageRating")
    public Double getAverageRatingByProduct(
            @RequestParam Long productId) {

        return service.getAverageRatingByProduct(productId);
    }
}