package com.hemanth.MovieReview.controller;

import com.hemanth.MovieReview.service.MovieService;
import com.hemanth.MovieReview.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/title")
    public MovieResponse getByTitle(@RequestParam String title){
        return movieService.findMovie(title);

    }
    @GetMapping("/genre")
    public List<MovieResponse> getByGenre(@RequestParam  String genre){
        return movieService.findMoviesByGenre(genre);

    }


}
