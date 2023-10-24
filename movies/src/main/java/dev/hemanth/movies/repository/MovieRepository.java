package dev.hemanth.movies.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.hemanth.movies.document.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
	
	Optional<Movie>findMovieByImdbId(String imdbid);
		
	
}
