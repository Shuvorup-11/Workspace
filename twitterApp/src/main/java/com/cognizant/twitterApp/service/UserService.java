package com.cognizant.twitterApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.twitterApp.model.User;
import com.cognizant.twitterApp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser() {	
		return userRepository.findAll();
	}
	
	public boolean insertUser(User user) {
		try {
			userRepository.insert(user);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public User searchByUserName(String userName) {
		return userRepository.findByFirstName(userName);
	} 
}
