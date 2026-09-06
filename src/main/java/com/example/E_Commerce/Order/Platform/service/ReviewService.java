package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.entities.Review;
import com.example.E_Commerce.Order.Platform.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.nio.file.Files.find;
import static java.util.Collections.copy;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService implements CrudService<ReviewDTO> {

    private final ReviewRepository repo;
    public ReviewDTO create(ReviewDTO d) {

        Review e = new Review();

        copy(d, e);

        e.setIsActive(true);

        return ReviewDTO.convertToDTO(
                repo.save(e)
        );
    }


    public List<ReviewDTO> getAll() {

        return ReviewDTO.convertToDTO(
                repo.findAllByIsActiveTrue()
        );
    }


    public ReviewDTO getById(Long id) {

        return ReviewDTO.convertToDTO(
                find(id)
        );
    }


    public ReviewDTO update(Long id, ReviewDTO d) {

        Review e = find(id);

        copy(d, e);

        return ReviewDTO.convertToDTO(
                repo.save(e)
        );
    }



}

