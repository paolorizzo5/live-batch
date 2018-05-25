package com.paolorizzo.betting.live_batch.constants;

public class SkybetConstants {

	public static final String PREVIEW_MODE = "PREVIEW";
	public static final String LIVE_MODE = "LIVE";
	public static final String FAKE_MODE = "FAKE";
	public static final String TODAY_MODE = "TODAY";
	public static final String TOMORROW_MODE = "TOMORROW";
	
	
	
	public static final String XPATH_TITLE_CARD = "//h2[@class='cardHeading__heading cardHeading__heading-capitalize']";
	
	public static final String XPATH_EVENTLIST = "//div[@class='eventlist__table']";
	public static final String XPATH_EVENTLIST_DETAIL_LINK = "//a[@class='eventListEventDetail__link']";
	public static final String XPATH_EVENTLIST_DETAIL_TIME = "//div[@class='eventListEventDetail__clockContainer']";
	public static final String XPATH_SCORECONTENT = "//div[@class='sr-content']";
	
	public static final String XPATH_LIVETIME = "//div[@class='sr-live hasCountdown']";
	public static final String XPATH_LIVETIME_SIMPLE = "//div[@class='qa-event-time']";
	
	
	
	public static final String REGULAR_EXPRESSIONS_END_OF_LINE = "[\\r\\n]+";
	public static final String XPATH_LIVETIME_CLOCK = "//span[@class='qa-event-clock']";
	public static final String XPATH_SCORECONTENT_HOME_TEAM = "//div[@class='qa-home-score']";
	public static final String XPATH_SCORECONTENT_AWAY_TEAM = "//div[@class='qa-away-score']";
	public static final String XPATH_INFO_WRAPER = "//div[@class='sr-live']";
}
