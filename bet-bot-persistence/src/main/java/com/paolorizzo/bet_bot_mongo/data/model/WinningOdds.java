package com.paolorizzo.bet_bot_mongo.data.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.paolorizzo.bet_bot_mongo.data.model.ids.WinningOddsId;

@Document(collection="winning_odds")
public class WinningOdds {
	
	@Id
	private WinningOddsId winningOddsId;
	
	private List<Bettype> bettypes;

	public List<Bettype> getBettypes() {
		return bettypes;
	}

	public void setBettypes(List<Bettype> bettypes) {
		this.bettypes = bettypes;
	}

	public WinningOddsId getWinningOddsId() {
		return winningOddsId;
	}

	public void setWinningOddsId(WinningOddsId winningOddsId) {
		this.winningOddsId = winningOddsId;
	}

	
	

}
