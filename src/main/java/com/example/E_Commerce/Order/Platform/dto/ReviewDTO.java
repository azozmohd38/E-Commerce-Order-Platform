package com.example.E_Commerce.Order.Platform.dto;

import com.example.E_Commerce.Order.Platform.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long id;
    private Integer rating;
    private String comment;
    private Date reviewDate;

    public static ReviewDTO convertToDTO(Review review) {

        return ReviewDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .reviewDate(review.getReviewDate())
                .build();
    }
    public static List<ReviewDTO> convertToDTO(List<Review> reviews) {

        return reviews.stream()
                .map(ReviewDTO::convertToDTO)
                .collect(Collectors.toList());
    }


}

