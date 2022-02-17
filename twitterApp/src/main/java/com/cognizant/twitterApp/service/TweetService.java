package com.cognizant.twitterApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.twitterApp.model.Tweets;
import com.cognizant.twitterApp.model.User;
import com.cognizant.twitterApp.repository.TweetsRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetsRepository tweetRepository;

	public List<Tweets> getAllTweets() {
		return tweetRepository.findAll();
	}
	
	public String postNewTweet(Tweets tweet) {
		return "Tweet saved: " + tweetRepository.insert(tweet).toString();
	} 
	
	public List<Tweets> getAllByUser(String userName ) {
		return tweetRepository.findTweetsByHandler(userName);
	}

	public List<Tweets> searcTweetsByUserName(String userName) {
		// TODO Auto-generated method stub
		return tweetRepository.findTweetsByHandler(userName);
	}

	public Tweets updateTweet(Tweets tweet, String userName, String id) {
		// TODO Auto-generated method stub
		Optional<Tweets> tweetFound = tweetRepository.findById(id);
		Tweets tweeted = tweetFound.get();
		tweeted.setMessage(tweet.getMessage());
		tweeted.setTime(tweet.getTime());
		tweeted.setHandler(userName);
		return tweetRepository.save(tweeted);
	}

	public boolean deleteTweet(String userName, String id) {
		// TODO Auto-generated method stub
		try {
		tweetRepository.deleteById(id);
		return true;
		} catch(Exception e) {
			return false;
		}
	}
}
