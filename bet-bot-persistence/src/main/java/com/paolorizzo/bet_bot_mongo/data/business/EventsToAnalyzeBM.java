package com.paolorizzo.bet_bot_mongo.data.business;

import java.util.List;

public interface EventsToAnalyzeBM {

	List<String> findAllAsStrings();

	void addAll(List<String> strings);

}
