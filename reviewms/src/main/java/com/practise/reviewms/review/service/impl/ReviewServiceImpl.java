package com.practise.reviewms.review.service.impl;

import com.practise.reviewms.review.entity.Review;
import com.practise.reviewms.review.repository.ReviewRepository;
import com.practise.reviewms.review.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long id, Review review) {
        if (id != null && review!=null){
            review.setCompanyId(id);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviews(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review review) {
        Review review1 = reviewRepository.findById(reviewId).orElse(null);
        if (review1 != null){
            review.setId(review.getId());
            review.setTitle(review.getTitle());
            review.setDescription(review.getDescription());
            review.setRating(review.getRating());
            review.setCompanyId(review.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if ( review!= null){
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
