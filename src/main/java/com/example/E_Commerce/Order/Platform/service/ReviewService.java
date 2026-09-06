package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService implements CrudService<ReviewDTO> {

    private final ReviewRepository repo;


}

