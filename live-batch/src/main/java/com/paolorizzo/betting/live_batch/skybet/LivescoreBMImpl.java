package com.paolorizzo.betting.live_batch.skybet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.business.FinishedEventBM;
import com.paolorizzo.bet_bot_mongo.data.business.SoccerEventArchiveBM;
import com.paolorizzo.bet_bot_mongo.data.business.SoccerEventBM;
import com.paolorizzo.bet_bot_mongo.data.enums.SoccerEventStatus;
import com.paolorizzo.bet_bot_mongo.data.exceptions.BusinessException;
import com.paolorizzo.bet_bot_mongo.data.model.FinishedEvent;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;
import com.paolorizzo.betting.live_batch.constants.LivescoreConstants;
import com.paolorizzo.betting.live_batch.constants.SkybetConstants;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;

@Component
public class LivescoreBMImpl implements LivescoreBM {
	
	@Autowired
	WebDriver webDriver;
	
	@Autowired
	FinishedEventBM finishedEventBM;

	@Autowired
	SoccerEventBM soccerEventBM;

	@Autowired
	SoccerEventArchiveBM soccerEventArchiveBM;

	@Override
	public void setFinalScore(String livescoreBaseUrl) {
		
		Long millis = System.currentTimeMillis();
		webDriver.navigate().to(livescoreBaseUrl);
		List<WebElement> tablesFinished = webDriver.findElements(By.xpath(LivescoreConstants.XPATH_STAGE_FINISHED));
		List<FinishedEvent> finishedEvents = new ArrayList<>();
		for (WebElement table : tablesFinished) {
			String[] splitted = table.getText().split(SkybetConstants.REGULAR_EXPRESSIONS_END_OF_LINE);
			if(splitted.length > 2 && splitted[2].contains("Finale")){
				FinishedEvent finishedEvent = new FinishedEvent();
				finishedEvent.setHomeTeam(splitted[3].replaceAll("^\\s+", ""));
				finishedEvent.setAwayTeam(splitted[5]);
				String[] score = splitted[4].trim().split("-");
				finishedEvent.setHomeGoals(Integer.parseInt(score[0].trim()));
				finishedEvent.setAwayGoals(Integer.parseInt(score[1].trim()));
				finishedEvents.add(finishedEvent);
			}
		}
		
		try {
			
			//refillSoccerEventsFromArchive();
			
			List<SoccerEvent> soccerEvents = soccerEventBM.getAll();
			for (FinishedEvent finishedEvent : finishedEvents) {
				for (SoccerEvent soccerEvent : soccerEvents) {
					boolean match = match(finishedEvent,soccerEvent);
					if(match){
						SoccerEventArchive soccerEventArchive = new SoccerEventArchive();
						BeanUtils.copyProperties(soccerEvent, soccerEventArchive);
						soccerEventArchive.setHomeGoals(finishedEvent.getHomeGoals());
						soccerEventArchive.setAwayGoals(finishedEvent.getAwayGoals());
						soccerEventArchive.setSoccerEventStatus(SoccerEventStatus.ARCHIVED);
						soccerEventArchive.setInsertDate(new Date());
						SoccerEventArchive ret =  soccerEventArchiveBM.save(soccerEventArchive);
						if (ret != null){
							soccerEventBM.delete(soccerEvent);
						}
					}
				}
			}
		} catch (BusinessException e) {
			
		}
	}

	private void refillSoccerEventsFromArchive() {
		
		List<SoccerEventArchive> events = soccerEventArchiveBM.findAll();
		for (SoccerEventArchive soccerEventArchive : events) {
			SoccerEvent soccerEvent = new SoccerEvent();
			BeanUtils.copyProperties(soccerEventArchive, soccerEvent);
			soccerEventBM.save(soccerEvent);
			soccerEventArchiveBM.delete(soccerEventArchive);
		}
	}

	private boolean match(FinishedEvent finishedEvent, SoccerEvent soccerEvent) {
		NormalizedLevenshtein normalizedLevenshtein = new NormalizedLevenshtein();
		double homeDistance = normalizedLevenshtein.distance(finishedEvent.getHomeTeam(), soccerEvent.getHomeTeam());
		double awayDistance = normalizedLevenshtein.distance(finishedEvent.getAwayTeam(), soccerEvent.getAwayTeam());
		return homeDistance < 0.2d || awayDistance < 0.2d;
		
	}

	

}
