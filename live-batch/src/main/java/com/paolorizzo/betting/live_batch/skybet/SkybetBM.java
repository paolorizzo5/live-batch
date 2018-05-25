package com.paolorizzo.betting.live_batch.skybet;

import java.util.List;
import java.util.Map;

import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;

public interface SkybetBM {

	List<String> getLinks(String url);

	List<String> clickNationsToGetCompetitions(String url);

	Map<String, String> getSoccerEventLinks(String link);

	void saveLiveEventDetails(String string);

	SoccerEvent initSoccerEvent(String url, String time);

}
