package com.paolorizzo.bet_bot_mongo.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events_to_analyze")
public class EventsToAnalyze {
	
	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventsToAnalyze(String name) {
		super();
		this.name = name;
	}

	
	
	

}
