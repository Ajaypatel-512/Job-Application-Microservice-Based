package com.practise.reviewms.review.service;

import com.practise.reviewms.review.entity.Review;

import java.util.List;

public interface ReviewService {
        List<Review> getAllReviews(Long companyId);
        boolean addReview(Long id, Review review);
        Review getReviews(Long reviewId);
        boolean updateReview( Long reviewId, Review review);
        boolean deleteReview(Long reviewId);
}
