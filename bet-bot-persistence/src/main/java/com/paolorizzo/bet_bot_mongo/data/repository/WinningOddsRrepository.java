package com.paolorizzo.bet_bot_mongo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paolorizzo.bet_bot_mongo.data.model.EventsToAnalyze;
import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;
import com.paolorizzo.bet_bot_mongo.data.model.ids.WinningOddsId;

public interface WinningOddsRrepository  extends MongoRepository<WinningOdds, WinningOddsId>{

}
