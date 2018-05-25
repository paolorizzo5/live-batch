package com.paolorizzo.bet_bot_mongo.data.business;

import java.util.List;

import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;

public interface WinningOddsBM {

	boolean isEmpty();

	void init();

	WinningOdds get(Integer homeGoals, Integer awayGoals);

}
