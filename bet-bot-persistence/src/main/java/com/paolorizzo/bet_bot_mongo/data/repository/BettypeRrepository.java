package com.paolorizzo.bet_bot_mongo.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.paolorizzo.bet_bot_mongo.data.model.Bettype;

public interface BettypeRrepository  extends MongoRepository<Bettype, String>{

}
