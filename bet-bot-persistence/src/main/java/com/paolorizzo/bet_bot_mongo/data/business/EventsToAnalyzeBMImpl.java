package com.paolorizzo.bet_bot_mongo.data.business;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.EventsToAnalyze;
import com.paolorizzo.bet_bot_mongo.data.repository.EventsToAnalyzeRrepository;

@Component
@CacheConfig(cacheNames = "eventsToAnalyzeCache")
public class EventsToAnalyzeBMImpl implements EventsToAnalyzeBM{

	@Autowired
	EventsToAnalyzeRrepository eventsToAnalyzeRrepository;
	

	@Cacheable
	@Override
	public List<String> findAllAsStrings() {
		Long millis = System.currentTimeMillis();
		List<String> ret = new ArrayList<String>();
		List<EventsToAnalyze> list = eventsToAnalyzeRrepository.findAll();
		for (EventsToAnalyze eventsToAnalyze : list) {
			ret.add(eventsToAnalyze.getName());
		}
		Loggers.performance.info(MessageFormat.format("EventsToAnalyzeBMImpl.findAllAsStrings {0}", System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public void addAll(List<String> strings) {
		List<EventsToAnalyze> list = new ArrayList<EventsToAnalyze>();
		for (String name : strings) {
			list.add(new EventsToAnalyze(name));
		}
		eventsToAnalyzeRrepository.saveAll(list);
	}

	
	
}
