package com.hemanth.MovieReview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hemanth.MovieReview.service.response.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "review_table")
public class Review {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "id", nullable = false)
    private  Long id;

    private  double rating;

    private String movieReview;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
    private  Movie movie;

@CreationTimestamp
    private Date dateCreated;
@UpdateTimestamp
    private Date dateUpdated;
public static  ReviewResponse toReviewResponse(Review review){
    return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
}
public static  List<ReviewResponse> toReviewResponse(List<Review> reviews){
    if(Objects.isNull(reviews))
        return new ArrayList<>();
    return reviews.stream().map(Review::toReviewResponse).collect(Collectors.toList());

}
}
