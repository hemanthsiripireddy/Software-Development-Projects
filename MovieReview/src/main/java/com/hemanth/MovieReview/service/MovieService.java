package com.hemanth.MovieReview.service;

import com.hemanth.MovieReview.domain.Genre;
import com.hemanth.MovieReview.domain.Movie;
import com.hemanth.MovieReview.repository.MovieRepository;
import com.hemanth.MovieReview.service.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {
@Autowired
    private MovieRepository movieRepository;
    public MovieResponse findMovie(String title){
        Movie movie=movieRepository.findByTitle(title);
        if(Objects.nonNull(movie))
            return movie.toMovieResponse();
       return null;

    }
    public List<MovieResponse> findMoviesByGenre(String genre){
        if(Arrays.stream(Genre.values()).noneMatch(g->g.toString().equals(genre)))
        return new ArrayList<>();

        List<Movie> movieList=movieRepository.findByGenre(Genre.valueOf(genre));
        if(!CollectionUtils.isEmpty(movieList)){
            List<MovieResponse> list=movieList.stream()
                    .sorted(Comparator.comparing(Movie::getRating,Comparator.reverseOrder())).
                    map(m->m.toMovieResponse()).collect(Collectors.toList());
            if(list.size()>5)
                return list.subList(0,4);
            return list;

        }
        return  new ArrayList<>();
    }
}
