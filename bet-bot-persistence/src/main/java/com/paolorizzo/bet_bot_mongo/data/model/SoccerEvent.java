package com.paolorizzo.bet_bot_mongo.data.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.paolorizzo.bet_bot_mongo.data.enums.SoccerEventStatus;

@Document(collection = "soccer_events")
public class SoccerEvent extends LogData{
	
	@Id
	private String url;
	
	private SoccerEventStatus soccerEventStatus;
	
	private String homeTeam;
	
	private String awayTeam;
	
	private Date startTime;
	
	private List<LiveOdds> liveOdds;

	public SoccerEvent(String url) {
		this.url = url;
	}

	public SoccerEvent() {
		// TODO Auto-generated constructor stub
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SoccerEventStatus getSoccerEventStatus() {
		return soccerEventStatus;
	}

	public void setSoccerEventStatus(SoccerEventStatus soccerEventStatus) {
		this.soccerEventStatus = soccerEventStatus;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public List<LiveOdds> getLiveOdds() {
		return liveOdds;
	}

	public void setLiveOdds(List<LiveOdds> liveOdds) {
		this.liveOdds = liveOdds;
	}

	public String getEventString() {
		return homeTeam + "-" + awayTeam;
	}
	
	
}
