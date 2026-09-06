package com.example.E_Commerce.Order.Platform.service;

import com.example.E_Commerce.Order.Platform.dto.ReviewDTO;
import com.example.E_Commerce.Order.Platform.entities.Customer;
import com.example.E_Commerce.Order.Platform.entities.Product;
import com.example.E_Commerce.Order.Platform.entities.Review;
import com.example.E_Commerce.Order.Platform.repositories.CustomerRepository;
import com.example.E_Commerce.Order.Platform.repositories.OrderItemRepository;
import com.example.E_Commerce.Order.Platform.repositories.ProductRepository;
import com.example.E_Commerce.Order.Platform.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewService implements CrudService<ReviewDTO> {

    private final ReviewRepository repo;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    private final OrderItemRepository orderItemRepository;


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


    public void delete(Long id) {

        Review e = find(id);

        e.setIsActive(false);

        repo.save(e);
    }


    Review find(Long id) {

        return EntityHelper.active(
                repo,
                id,
                "Review"
        );
    }


    private void copy(ReviewDTO d, Review e) {

        e.setRating(d.getRating());

        e.setComment(d.getComment());

        e.setReviewDate(d.getReviewDate());
    }


    public ReviewDTO submitReview(
            Long customerId,
            Long productId,
            Integer rating,
            String comment) {

        Customer customer = EntityHelper.active(
                customerRepository,
                customerId,
                "Customer"
        );

        Product product = EntityHelper.active(
                productRepository,
                productId,
                "Product"
        );

        if (rating < 1 || rating > 5) {

            throw new RuntimeException(
                    "Rating must be between 1 and 5"
            );
        }

        boolean hasOrderedProduct =
                orderItemRepository
                        .existsByOrderCustomerAndProductAndIsActiveTrue(
                                customer,
                                product
                        );

        if (!hasOrderedProduct) {

            throw new RuntimeException(
                    "Customer has not ordered this product"
            );
        }

        Review review = new Review();

        review.setCustomer(customer);

        review.setProduct(product);

        review.setRating(rating);

        review.setComment(comment);

        review.setReviewDate(new Date());

        review.setIsActive(true);

        review.setCreatedDate(new Date());

        return ReviewDTO.convertToDTO(
                repo.save(review)
        );
    }


    public Double getAverageRatingByProduct(Long productId) {

        return repo.getAverageRatingByProduct(productId);
    }
}