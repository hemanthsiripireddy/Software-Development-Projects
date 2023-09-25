package com.example.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepository mRepo;

	public String welcomeMsg() {
		// TODO Auto-generated method stub
		return "Welcome to springboot services";
	}

	public ArrayList<Movie> getMovies() {
		// TODO Auto-generated method stub
		ArrayList<Movie>movie=(ArrayList<Movie>)mRepo.findAll();
		return movie;
	}

	public Movie getMovieById(String id) {
		// TODO Auto-generated method stub
		Optional<Movie>movie=mRepo.findById(Integer.parseInt(id));
		
		return movie.get();
	}

	public String insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		mRepo.save(movie);
		return "Movie inserted Successfully";
	}

}
