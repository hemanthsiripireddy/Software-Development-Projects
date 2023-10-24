package dev.hemanth.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.hemanth.movies.entity.Moviedb;
import dev.hemanth.movies.repository.MoviedbRepository;
@Service
public class MoviedbService {
	@Autowired
	private MoviedbRepository moviedbRepository;
	
	public List<Moviedb> getAllMoviesFromDB(){
		return moviedbRepository.findAll();
		
	}

}
