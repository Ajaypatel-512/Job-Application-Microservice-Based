package com.practise.reviewms.review;

import com.practise.reviewms.review.entity.Review;
import com.practise.reviewms.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addReview(@RequestParam Long companyId,@RequestBody Review review){
        boolean isReviewed = reviewService.addReview(companyId, review);
        if (isReviewed)
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        Review reviews = reviewService.getReviews(reviewId);
        if (reviews  != null)
            return new ResponseEntity<>(reviews,HttpStatus.OK);
        return new ResponseEntity<>(reviews,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Review review){
        boolean b = reviewService.updateReview(reviewId, review);
        if (b) return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not updated",HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean b = reviewService.deleteReview(reviewId);
        if (b) return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not deleted",HttpStatus.NOT_FOUND);
    }

}
