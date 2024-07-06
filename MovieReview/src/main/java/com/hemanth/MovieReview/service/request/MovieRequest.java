package com.hemanth.MovieReview.service.request;

import com.hemanth.MovieReview.domain.Genre;
import com.hemanth.MovieReview.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    private  String title;
    private Genre genre;

    public Movie toMovie(){
        return Movie.builder().title(title).genre(genre).build();
    }
}
