package com.hemanth.MovieReview.repository;

import com.hemanth.MovieReview.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
@Query(value="select avg(rating) from review_table where  movie_id=?",nativeQuery = true)
    Double getReviewAvg(Long id);
}
