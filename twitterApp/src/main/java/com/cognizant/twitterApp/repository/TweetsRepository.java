package com.cognizant.twitterApp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.twitterApp.model.Tweets;

@Repository
public interface TweetsRepository extends MongoRepository<Tweets, String>{
	@Query("{'handler' : ?0}")
	List<Tweets> findTweetsByHandler(String handler);

}
