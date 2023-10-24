package dev.hemanth.movies.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.hemanth.movies.document.Review;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
