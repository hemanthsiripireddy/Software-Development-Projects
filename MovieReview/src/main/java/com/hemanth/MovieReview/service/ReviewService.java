package com.hemanth.MovieReview.service;

import com.hemanth.MovieReview.domain.Movie;
import com.hemanth.MovieReview.domain.Review;
import com.hemanth.MovieReview.repository.MovieRepository;
import com.hemanth.MovieReview.repository.ReviewRepository;
import com.hemanth.MovieReview.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ReviewRepository reviewRepository;


    public void addReview(Review review){

        Movie movie =movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);

        if(movie!=null){
            Double avg=reviewRepository.getReviewAvg(movie.getId());
            movie.setRating(avg);
            movieRepository.save(movie);
        }

        return;
    }
    public ReviewResponse findByReviewId(Long reviewId){
        Optional<Review> review=reviewRepository.findById(reviewId);

        return review.map(Review::toReviewResponse).orElse(null);
    }
}
