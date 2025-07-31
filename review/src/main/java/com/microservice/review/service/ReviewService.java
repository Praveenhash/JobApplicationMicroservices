package com.microservice.review.service;


import com.microservice.review.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    Review findReviewById(Long reviewId);

    boolean addReviews(Long id, Review review);

    boolean updateReview(Long reviewId, Review review);

    boolean deleteReview( Long reviewId);
}
