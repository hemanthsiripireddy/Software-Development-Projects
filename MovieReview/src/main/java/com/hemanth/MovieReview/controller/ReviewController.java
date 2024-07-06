package com.hemanth.MovieReview.controller;

import com.hemanth.MovieReview.service.ReviewService;
import com.hemanth.MovieReview.service.request.ReviewRequest;
import com.hemanth.MovieReview.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody  ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());


    }
@GetMapping("/find")
    public ReviewResponse getReview(@RequestParam  Long reviewId){
        return reviewService.findByReviewId(reviewId);
    }
}
