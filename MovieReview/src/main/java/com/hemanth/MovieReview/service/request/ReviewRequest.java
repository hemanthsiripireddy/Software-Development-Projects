package com.hemanth.MovieReview.service.request;

import com.hemanth.MovieReview.domain.Movie;
import com.hemanth.MovieReview.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private  String movieReview;
    private  Double rating;
    private Long movieId;

    public Review toReview(){
        return Review.builder().movieReview(movieReview).rating(rating).
                movie(Movie.builder().id(movieId).build()).build();
    }
}
