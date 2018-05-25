package com.paolorizzo.betting.live_batch.tasks;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.business.BettypeBM;
import com.paolorizzo.bet_bot_mongo.data.business.EventsToAnalyzeBM;
import com.paolorizzo.bet_bot_mongo.data.business.WinningOddsBM;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.betting.live_batch.livescore.LivescoreWebScraper;
import com.paolorizzo.betting.live_batch.skybet.SkybetParser;

@Component
public class ScheduledTasks {

	@Autowired
	EventsToAnalyzeBM eventsToAnalyzeBM;

	@Autowired
	SkybetParser skybetParser;

	@Autowired
	LivescoreWebScraper livescoreWebScraper;
	
	@Autowired
	WinningOddsBM winningOddsBM;
	
	@Autowired
	BettypeBM bettypeBM;
	

	private static final long EVERY_MINUTE = 1000 *60;

	private static final long EVERY_DAY = 1000 * 60 * 60 *24;

	private static final long EVERY_HOUR = 1000 * 60 * 60;

	private static final long EVERY_LIFE = 1000 * 60 * 60 *24 * 365 * 100;
	
	@Scheduled(fixedRate = EVERY_MINUTE)
	public void getLiveStats() {
		try {
			skybetParser.parseLiveEvents();
		} catch (IOException e) {
			Loggers.root.error("exception in parsing live events",e);
		}
	}
	
	@Scheduled(fixedRate = EVERY_HOUR)
	public void setFinalScore() {
		livescoreWebScraper.setFinalScore();
	}
	
	@Scheduled(fixedRate = EVERY_LIFE)
	public void initAll() {
		if(bettypeBM.isEmpty()){
			bettypeBM.init();
		}
		
		if(winningOddsBM.isEmpty()){
			winningOddsBM.init();
		}
	}

//	@Scheduled(fixedRate = EVERY_MINUTE)
//	public void getTodayPreview() {
//		Long millis = System.currentTimeMillis();
//		if (eventsToAnalyzeBM.findAllAsStrings().isEmpty()) {
//			eventsToAnalyzeBM.addAll(Arrays.asList("1X2", "Goal / No Goal", "Segna il 1° Goal"));
//		}
//		skybetParser.getTodayPreview();
//		if(Loggers.performanceTasks.isInfoEnabled()){
//			Loggers.performanceTasks.info(MessageFormat.format("getTodayPreview DURATION={0}",System.currentTimeMillis() - millis));	
//		}
//
//	}

}
