package com.example.E_Commerce.Order.Platform.Controllers;

import com.example.E_Commerce.Order.Platform.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping("add")
    public ReviewDTO create(@RequestBody ReviewDTO d) {

        return service.create(d);
    }


}

