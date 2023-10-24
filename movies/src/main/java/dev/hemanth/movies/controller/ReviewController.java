package dev.hemanth.movies.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hemanth.movies.document.Review;
import dev.hemanth.movies.service.ReviewService;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public ResponseEntity<Review>createReview(@RequestBody Map<String,String>payLoad){
		Review review=reviewService.createReview(payLoad.get("reviewBody"), payLoad.get("imdbId"));
		return  new ResponseEntity<Review>(review,HttpStatus.CREATED);
		
	}
	

}
