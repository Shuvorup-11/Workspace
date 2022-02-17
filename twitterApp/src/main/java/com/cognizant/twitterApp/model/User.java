package com.cognizant.twitterApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(collection = "User")
public class User {
	
	@Id
	@JsonProperty("id")
	private String id;
	@Field("passWord")
	@JsonProperty("passWord")
	private String passWord;
	@Field("firstName")
	@JsonProperty("firstName")
	private String firstName;
	@Field("lastName")
	@JsonProperty("lastName")
	private String lastName;
	@Field("email")
	@Indexed(unique = true)
	@JsonProperty("email")
	private String email;
	@Field("contactNumber")
	@JsonProperty("contactNumber")
	private int contactNumber;
	
}
