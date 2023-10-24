package dev.hemanth.movies.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hemanth.movies.document.Movie;
import dev.hemanth.movies.entity.Moviedb;
import dev.hemanth.movies.service.MovieService;
import dev.hemanth.movies.service.MoviedbService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MoviedbService moviedbService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
    	
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/db")
    public List<Moviedb> getAllMoviesFromDB() {
    return	moviedbService.getAllMoviesFromDB();
    }
    
    @GetMapping("/db1")
    public String getAllMoviesFromDB1() {
    return	moviedbService.getAllMoviesFromDB().get(0).toString();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String id){
    	return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    	
    }
    
    
}
