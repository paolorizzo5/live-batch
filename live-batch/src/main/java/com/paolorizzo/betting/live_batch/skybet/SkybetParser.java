package com.paolorizzo.betting.live_batch.skybet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.paolorizzo.betting.live_batch.constants.SkybetConstants;

@Component
@PropertySource("application.properties")
public class SkybetParser {
	
	@Autowired
	SkybetWebScraper skybetWebScraper;
	
	@Autowired
	Environment environment;
	
	@Value("${skybet.url}")
	private String skybetUrl;
	
	@Value("${skybet.tomorrow.url}")
	private String skybetTomorrowUrl;
	
	@Value("${skybet.today.url}")
	private String skybetTodayUrl;
	
	@Value("${skybet.calcio.url}")
	private String skybetCalcioUrl;
	
	public void parseLiveEvents() throws IOException {
		skybetWebScraper.parseLiveEvents(skybetUrl);
	}
	
}
