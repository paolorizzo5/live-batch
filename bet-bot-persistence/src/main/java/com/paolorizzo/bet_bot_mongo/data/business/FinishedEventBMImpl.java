package com.paolorizzo.bet_bot_mongo.data.business;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.exceptions.BusinessException;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.FinishedEvent;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.bet_bot_mongo.data.repository.FinishedEventRepository;
import com.paolorizzo.bet_bot_mongo.data.repository.SoccerEventRepository;

@Component
public class FinishedEventBMImpl implements FinishedEventBM{
	
	@Autowired
	FinishedEventRepository finishedEventRepository;

	@Override
	public FinishedEvent save(FinishedEvent finishedEvent) {
		Long millis = System.currentTimeMillis();
		FinishedEvent ret = finishedEventRepository.save(finishedEvent);
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("FinishedEventBMImpl.save={0}" , System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public List<FinishedEvent> findAll() {
		Long millis = System.currentTimeMillis();
		List<FinishedEvent> ret = finishedEventRepository.findAll();
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("FinishedEventBMImpl.findAll={0}" , System.currentTimeMillis() - millis));
		return ret;
	}


	
}
