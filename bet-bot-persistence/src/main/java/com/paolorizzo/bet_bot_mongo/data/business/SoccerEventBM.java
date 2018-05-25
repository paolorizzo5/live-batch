package com.paolorizzo.bet_bot_mongo.data.business;

import java.util.List;

import com.paolorizzo.bet_bot_mongo.data.exceptions.BusinessException;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;

public interface SoccerEventBM {

	SoccerEvent save(SoccerEvent soccerEvent);

	SoccerEvent findById(String url);

	void delete(SoccerEvent soccerEvent);

	List<SoccerEvent> getAll() throws BusinessException;

}
