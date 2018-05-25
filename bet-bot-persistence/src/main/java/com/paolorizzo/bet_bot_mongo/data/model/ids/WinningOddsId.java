package com.paolorizzo.bet_bot_mongo.data.model.ids;

public class WinningOddsId {
	
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
	
	public WinningOddsId(Integer homeGoals,Integer awayGoals) {
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
	}

}
