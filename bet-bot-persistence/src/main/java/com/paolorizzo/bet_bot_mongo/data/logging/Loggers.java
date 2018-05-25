package com.paolorizzo.bet_bot_mongo.data.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggers {
	
	public static final Logger performance = LoggerFactory.getLogger("performance");

	public static final Logger performanceTasks = LoggerFactory.getLogger("performanceTasks");

	public static final Logger root = LoggerFactory.getLogger("root");
	
	public static final Logger mongo = LoggerFactory.getLogger("mongo");
}
