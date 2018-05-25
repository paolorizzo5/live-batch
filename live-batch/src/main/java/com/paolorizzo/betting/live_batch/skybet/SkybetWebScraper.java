package com.paolorizzo.betting.live_batch.skybet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.paolorizzo.bet_bot_mongo.data.business.EventsToAnalyzeBM;

public class SkybetWebScraper {

	@Value("${skybet.base.url}")
	private String skybetBaseUrl;

	@Value("${skybet.base.url}")
	private String skybetTodayUrl;

	@Autowired
	EventsToAnalyzeBM eventsToAnalyzeBM;

	@Autowired
	SkybetBM skybetBM;

	private static final Logger logger = LoggerFactory.getLogger(SkybetWebScraper.class);

	public void parseLiveEvents(String url) {
		List<String> soccerEventLinks = skybetBM.getLinks(url);
		for (String soccerEventLink : soccerEventLinks) {
			skybetBM.saveLiveEventDetails(soccerEventLink);
		}
	}

}
