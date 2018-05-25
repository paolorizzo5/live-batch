package com.paolorizzo.bet_bot_mongo.data.business;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.enums.Bettypes;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.Bettype;
import com.paolorizzo.bet_bot_mongo.data.repository.BettypeRrepository;

@Component
public class BettypeBMImpl implements BettypeBM {

	@Autowired
	BettypeRrepository bettypeRepository;
	
	@Override
	public boolean isEmpty() {
		Long millis = System.currentTimeMillis();
		long count = bettypeRepository.count();
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("BettypeRrepository.IsEmpty {0}" , System.currentTimeMillis() - millis));
		return count == 0;
	}

	@Override
	public void init() {
		for (Bettypes element : Bettypes.values()) {
			Bettype bettype = new Bettype();
			bettype.setDescription(element.getDescription());
			bettype.setKey(element.getKey());
			bettype.setParent(element.getParent());
			bettypeRepository.save(bettype);
		}
	}

	
}
