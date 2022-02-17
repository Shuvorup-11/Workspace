package com.cognizant.twitterApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.twitterApp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	@Query("{'handler' : ?0}")
	public User findByFirstName(String userName);

}
