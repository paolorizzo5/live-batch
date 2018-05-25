package com.paolorizzo.bet_bot_mongo.data.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="bet_types")
public class Bettype {
	
	private String parent;

	private String key;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
