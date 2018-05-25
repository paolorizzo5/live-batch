package com.paolorizzo.bet_bot_mongo.data.dto;

import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;

public class WinningOddsWithBestOdd extends WinningOdds {
	
	private Double bestOdd;

	public Double getBestOdd() {
		return bestOdd;
	}

	public void setBestOdd(Double bestOdd) {
		this.bestOdd = bestOdd;
	}
	
	

}
