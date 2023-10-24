package dev.hemanth.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import dev.hemanth.movies.document.Movie;
import dev.hemanth.movies.document.Review;
import dev.hemanth.movies.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository repositoryRepo;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Review createReview(String reviewBody,String imdbId) {
		
	
		
		//Review review=new Review(reviewBody);
		Review review= repositoryRepo.insert(new Review(reviewBody));
		mongoTemplate.update(Movie.class)
		.matching(Criteria.where("imdbId").is(imdbId))
		.apply(new Update().push("reviewIds").value(review))
		.first();
		return review;
		
	}

}
