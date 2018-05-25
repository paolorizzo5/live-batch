package com.paolorizzo.bet_bot_mongo.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LiveOdds extends LogData implements Serializable{
	
	private BigDecimal minute;
	private Integer homeGoals;
	private Integer awayGoals;
	private List<Odd> odds;
	
	public LiveOdds() {
		odds = new ArrayList<Odd>();
	}

	public BigDecimal getMinute() {
		return minute;
	}

	public void setMinute(BigDecimal minute) {
		this.minute = minute;
	}

	public List<Odd> getOdds() {
		return odds;
	}

	public void setOdds(List<Odd> odds) {
		this.odds = odds;
	}

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
