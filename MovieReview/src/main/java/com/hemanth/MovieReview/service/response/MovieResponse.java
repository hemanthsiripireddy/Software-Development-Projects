package com.hemanth.MovieReview.service.response;

import com.hemanth.MovieReview.domain.Genre;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private  Double rating;

    private List<ReviewResponse> reviews;

}
