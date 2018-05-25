package com.paolorizzo.betting.live_batch.livescore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.paolorizzo.betting.live_batch.skybet.LivescoreBM;
import com.paolorizzo.betting.live_batch.skybet.SkybetBM;

@Component
@PropertySource("application.properties")
public class LivescoreWebScraper {

	@Value("${livescore.base.url}")
	private String livescoreBaseUrl;
	
	@Autowired
	LivescoreBM livescoreBM;


	
	public void setFinalScore() {
		livescoreBM.setFinalScore(livescoreBaseUrl);
	}
	
	

}
