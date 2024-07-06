package com.hemanth.MovieReview.domain;

import com.hemanth.MovieReview.service.response.MovieResponse;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Movie implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id",nullable = false)
    private Long id;

    private String title;
@Enumerated(EnumType.STRING)
    private  Genre genre;

    private double rating;
@OneToMany(mappedBy = "movie")
    private List<Review> reviews;

public MovieResponse toMovieResponse(){
    return MovieResponse.builder().genre(genre).rating(rating).title(title).reviews(Review.toReviewResponse(reviews)).build();
}


}
