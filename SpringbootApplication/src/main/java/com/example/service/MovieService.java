package com.example.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.model.Movie;

@Service
public interface MovieService {
	
	String welcomeMsg();
	public ArrayList<Movie>getMovies();
	public Movie getMovieById(String id);
	public String insertMovie(Movie movie);

}
