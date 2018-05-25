package com.paolorizzo.bet_bot_mongo.data.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "soccer_events_archived")
public class SoccerEventArchive extends SoccerEvent{
	
	private Integer homeGoals;
	
	private Integer awayGoals;

	public Integer getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}

	public Integer getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(Integer awayGoals) {
		this.awayGoals = awayGoals;
	}
	
	
	
	
}
