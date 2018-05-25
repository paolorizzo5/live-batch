package com.paolorizzo.betting.live_batch.intralot;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IntralotHtmlParser {

	@Autowired
	IntralotWebScraper intralotWebScraper;
	
	public void parseSoccerEvents() throws IOException {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		intralotWebScraper = new IntralotWebScraper();
		intralotWebScraper.getPage("https://www.intralot.it/ScommesseLive");
	}

	private void parseSingleEvent(String matchIdElement) {

//		UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser)
//		userAgent.visit("https://www.intralot.it/scommesseliveevento?matchid=" + matchIdElement,5);          //visit google
//		
//		userAgent.doc.findEvery("<div id=tabDatiLive");
		


		

		
//		Document doc = Jsoup.connect("https://www.intralot.it/scommesseliveevento?matchid=" + matchIdElement).get();
//		Elements eventDetailElements = doc.select("div#tabDatiLive");
//		Elements divStatusInfo = eventDetailElements.select("span");
//		
//		doc.select("");

		
	}

}
