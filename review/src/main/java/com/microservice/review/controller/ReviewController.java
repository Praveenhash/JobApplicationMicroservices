package com.microservice.review.controller;

import com.microservice.review.entity.Review;
import com.microservice.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.findReviewById(reviewId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReviews(@RequestParam Long companyId, @RequestBody Review review){
        boolean isReviewSaved = reviewService.addReviews(companyId, review);
        if(isReviewSaved){
            return new ResponseEntity<>("Review added sucessfully..!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not added...!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,  @RequestBody Review review){
        boolean update = reviewService.updateReview(reviewId, review);
        if(update){
            return new ResponseEntity<>("Review updated sucessfully..!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean deleted = reviewService.deleteReview(reviewId);
        if(deleted){
            return new ResponseEntity<>("Review deleted successfully...!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
