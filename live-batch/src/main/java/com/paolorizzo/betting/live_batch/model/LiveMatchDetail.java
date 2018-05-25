package com.paolorizzo.betting.live_batch.model;


import java.math.BigDecimal;

public class LiveMatchDetail {
	
	private String homeTeam;
	private String awayTeam;
	
	private Integer homeGoals;
	private Integer awayGoals;
	
	private String time;
	
	private Integer homeShotsTotal;
	private Integer awayShotsTotal;
	
	private Integer homeRedCards;
	private Integer awayRedCards;
	
	private Integer homeAttacks;
	private Integer awayAttacks;
	
	private Integer homeDangerousAttacks;
	private Integer awayDangerousAttacks;
	
	
	private BigDecimal nextGoalScoredByHomeTeam;
	private BigDecimal nextGoalScoredByAwayTeam;
	private BigDecimal nextGoalScoredByNoTeam;
	
	
	

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getHomeShotsTotal() {
		return homeShotsTotal;
	}

	public void setHomeShotsTotal(Integer homeShotsTotal) {
		this.homeShotsTotal = homeShotsTotal;
	}

	public Integer getAwayShotsTotal() {
		return awayShotsTotal;
	}

	public void setAwayShotsTotal(Integer awayShotsTotal) {
		this.awayShotsTotal = awayShotsTotal;
	}

	public Integer getHomeRedCards() {
		return homeRedCards;
	}

	public void setHomeRedCards(Integer homeRedCards) {
		this.homeRedCards = homeRedCards;
	}

	public Integer getAwayRedCards() {
		return awayRedCards;
	}

	public void setAwayRedCards(Integer awayRedCards) {
		this.awayRedCards = awayRedCards;
	}

	public Integer getHomeAttacks() {
		return homeAttacks;
	}

	public void setHomeAttacks(Integer homeAttacks) {
		this.homeAttacks = homeAttacks;
	}

	public Integer getAwayAttacks() {
		return awayAttacks;
	}

	public void setAwayAttacks(Integer awayAttacks) {
		this.awayAttacks = awayAttacks;
	}

	public Integer getHomeDangerousAttacks() {
		return homeDangerousAttacks;
	}

	public void setHomeDangerousAttacks(Integer homeDangerousAttacks) {
		this.homeDangerousAttacks = homeDangerousAttacks;
	}

	public Integer getAwayDangerousAttacks() {
		return awayDangerousAttacks;
	}

	public void setAwayDangerousAttacks(Integer awayDangerousAttacks) {
		this.awayDangerousAttacks = awayDangerousAttacks;
	}

	public BigDecimal getNextGoalScoredByHomeTeam() {
		return nextGoalScoredByHomeTeam;
	}

	public void setNextGoalScoredByHomeTeam(BigDecimal nextGoalScoredByHomeTeam) {
		this.nextGoalScoredByHomeTeam = nextGoalScoredByHomeTeam;
	}

	public BigDecimal getNextGoalScoredByAwayTeam() {
		return nextGoalScoredByAwayTeam;
	}

	public void setNextGoalScoredByAwayTeam(BigDecimal nextGoalScoredByAwayTeam) {
		this.nextGoalScoredByAwayTeam = nextGoalScoredByAwayTeam;
	}

	public BigDecimal getNextGoalScoredByNoTeam() {
		return nextGoalScoredByNoTeam;
	}

	public void setNextGoalScoredByNoTeam(BigDecimal nextGoalScoredByNoTeam) {
		this.nextGoalScoredByNoTeam = nextGoalScoredByNoTeam;
	}

	@Override
	public String toString() {
		return "LiveMatchDetail [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", homeGoals=" + homeGoals
				+ ", awayGoals=" + awayGoals + ", time=" + time + ", homeShotsTotal=" + homeShotsTotal
				+ ", awayShotsTotal=" + awayShotsTotal + ", homeRedCards=" + homeRedCards + ", awayRedCards="
				+ awayRedCards + ", homeAttacks=" + homeAttacks + ", awayAttacks=" + awayAttacks
				+ ", homeDangerousAttacks=" + homeDangerousAttacks + ", awayDangerousAttacks=" + awayDangerousAttacks
				+ ", nextGoalScoredByHomeTeam=" + nextGoalScoredByHomeTeam + ", nextGoalScoredByAwayTeam="
				+ nextGoalScoredByAwayTeam + ", nextGoalScoredByNoTeam=" + nextGoalScoredByNoTeam + "]";
	}

	

}
