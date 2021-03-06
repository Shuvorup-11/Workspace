package com.cognizant.twitterApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.twitterApp.model.Tweets;
import com.cognizant.twitterApp.model.User;
import com.cognizant.twitterApp.service.TweetService;
import com.cognizant.twitterApp.service.UserService;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class Controller {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TweetService tweetService;

	@GetMapping("/users/all") 
    public List<User> getAllUser() { 
	   return userService.getAllUser(); 
    }
	
	@GetMapping("/user/search/{userName}") 
    public User getByUserName(@PathVariable String userName) { 
	   return userService.searchByUserName(userName); 
    }
	
	@GetMapping("/{userName}") 
    public List<Tweets> getTweetsByUserName(@PathVariable String userName) { 
	   return tweetService.searcTweetsByUserName(userName); 
    }
	
	@GetMapping("/all") 
    public List<Tweets> getAllTweets() { 
	   return tweetService.getAllTweets(); 
    }
	
	@PostMapping("/register")
	public boolean addUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	@PostMapping("/{userName}/add")
	public String addUser(@RequestBody Tweets tweet) {
		return tweetService.postNewTweet(tweet);
	}
	
	@PutMapping("/{userName}/update/{id}")
	public Tweets updateTweet(
			@RequestBody Tweets tweet, 
			@PathVariable String userName, 
			@PathVariable String id
			){
		return tweetService.updateTweet(tweet, userName, id);
		
	}
	
	@DeleteMapping("/{userName}/delete/{id}")
	public boolean deleteTweet( 
			@PathVariable String userName, 
			@PathVariable String id
			){
		return tweetService.deleteTweet(userName, id);
		
	}
	
	
	
}
