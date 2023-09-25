package com.example.controllers;

import java.util.ArrayList;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Movie;
import com.example.service.MovieService;
@CrossOrigin(maxAge = 3600)
@RestController
public class MovieRestController {
	
	//private static final Logger LOGGER=LoggerFactory.g
	@Autowired
	MovieService mService;
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/insertMovie", consumes="application/json")
	public String saveMovie(@RequestBody Movie movie) {
		return mService.insertMovie(movie);
		
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/getMovie/{id}")
	public Movie getMovieById(@PathVariable String id) {
		//oihgo
		return mService.getMovieById(id);
		
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(path= "/getMovies",produces = "application/json")
	public ArrayList<Movie> getMovies() {
		return mService.getMovies();
		
	}
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return mService.welcomeMsg();
	}
	
	

}
