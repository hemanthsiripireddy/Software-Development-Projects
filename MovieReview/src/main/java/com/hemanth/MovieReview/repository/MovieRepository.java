package com.hemanth.MovieReview.repository;

import com.hemanth.MovieReview.domain.Genre;
import com.hemanth.MovieReview.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    public Movie findByTitle(String title);

    public List<Movie> findByGenre(Genre genre);
}
