package com.paolorizzo.bet_bot_mongo.data.business;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.exceptions.BusinessException;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.bet_bot_mongo.data.repository.SoccerEventRepository;

@Component
public class SoccerEventBMImpl implements SoccerEventBM{
	
	@Autowired
	SoccerEventRepository soccerEventRepository;
	
	
	@Override
	public SoccerEvent save(SoccerEvent soccerEvent) {
		Long millis = System.currentTimeMillis();
		SoccerEvent ret = soccerEventRepository.save(soccerEvent);
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.save {0}" , System.currentTimeMillis() - millis));
		return ret;
	}


	@Override
	public SoccerEvent findById(String url) {
		Long millis = System.currentTimeMillis();
		SoccerEvent ret = null;
		Optional<SoccerEvent> optional = soccerEventRepository.findById(url);
		if(optional.isPresent()){
			ret = optional.get();
		}else{
			ret = null;
		}
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.findById {0}" , System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public void delete(SoccerEvent soccerEvent) {
		Long millis = System.currentTimeMillis();
		soccerEventRepository.delete(soccerEvent);
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.delete {0}" , System.currentTimeMillis() - millis));
	}

	@Override
	public List<SoccerEvent> getAll() throws BusinessException {
		try{
			Long millis = System.currentTimeMillis();
			List<SoccerEvent> soccerEvents = soccerEventRepository.findAll();
			if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.findAll={0}" , System.currentTimeMillis() - millis));
			return soccerEvents;	
		}catch(Exception exception){
			throw new BusinessException();
		}
	}

	
}
