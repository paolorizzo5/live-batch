package com.paolorizzo.bet_bot_mongo.data.business;

import java.util.List;

import com.paolorizzo.bet_bot_mongo.data.model.FinishedEvent;

public interface FinishedEventBM {

	FinishedEvent save(FinishedEvent finishedEvent);

	List<FinishedEvent> findAll();

	
}
