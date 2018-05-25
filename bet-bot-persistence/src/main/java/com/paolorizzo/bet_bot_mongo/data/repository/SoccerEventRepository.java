package com.paolorizzo.bet_bot_mongo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;

public interface SoccerEventRepository extends MongoRepository<SoccerEvent, String>{
	
}
