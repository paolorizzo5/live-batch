package com.paolorizzo.bet_bot_mongo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;


public interface SoccerEventArchiveRepository extends MongoRepository<SoccerEventArchive, Long>{
	
}
