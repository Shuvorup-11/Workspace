package com.cognizant.twitterApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Document("Tweets")
public class Tweets {
	
	@Id
	@JsonProperty("id")
	private String id;
	@Field("message")
	@JsonProperty("message")
	private String message;
	@Field("handler")
	@JsonProperty("handler")
	private String handler;
	
	public Tweets(String id, String message, String handler, String time) {
		super();
		this.id = id;
		this.message = message;
		this.handler = handler;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Field("time")
	@JsonProperty("time")
	private String time;

}
