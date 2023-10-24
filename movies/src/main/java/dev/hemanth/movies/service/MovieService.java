package dev.hemanth.movies.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.hemanth.movies.document.Movie;
import dev.hemanth.movies.repository.MovieRepository;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
    	
    	

        return movieRepository.findAll();

    }
    public Optional<Movie> singleMovie(String imdbId) {
    	return movieRepository.findMovieByImdbId(imdbId);
    }
}
