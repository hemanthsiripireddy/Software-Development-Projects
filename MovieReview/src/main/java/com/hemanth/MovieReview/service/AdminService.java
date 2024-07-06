package com.hemanth.MovieReview.service;

import com.hemanth.MovieReview.domain.Movie;
import com.hemanth.MovieReview.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    private AdminService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    public  Movie addMovie(Movie movie){
        return  movieRepository.save(movie);
    }

}
