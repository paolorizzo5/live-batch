package com.paolorizzo.betting.live_batch.skybet;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.business.EventsToAnalyzeBM;
import com.paolorizzo.bet_bot_mongo.data.business.SoccerEventArchiveBM;
import com.paolorizzo.bet_bot_mongo.data.business.SoccerEventBM;
import com.paolorizzo.bet_bot_mongo.data.enums.SoccerEventStatus;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.LiveOdds;
import com.paolorizzo.bet_bot_mongo.data.model.Odd;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.betting.live_batch.constants.SkybetConstants;


@Component
public class SkybetBMimpl implements SkybetBM {

	@Autowired
	WebDriver webDriver;

	@Autowired
	EventsToAnalyzeBM eventsToAnalyzeBM;

	@Autowired
	SoccerEventBM soccerEventBM;

	@Autowired
	SoccerEventArchiveBM soccerEventArchiveBM;

	private SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	private SimpleDateFormat simpleDateOnlyFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	@Async
	public SoccerEvent initSoccerEvent(String url,String time) {
		Long millis = System.currentTimeMillis();
		webDriver.navigate().to(url);
		if(Loggers.root.isDebugEnabled()){
			Loggers.root.debug(MessageFormat.format("navigated to {0}",url));
		}
		SoccerEvent soccerEvent = getScoreboardDataMode1();
		if(soccerEvent == null){
			soccerEvent = getSimpleDataModel();
		}
		soccerEvent.setUrl(url);
		soccerEvent.setSoccerEventStatus(SoccerEventStatus.SAVED);
		soccerEvent.setInsertDate(new Date());
		soccerEvent.setModifyDate(new Date());
		soccerEventBM.save(soccerEvent);
		if(Loggers.root.isInfoEnabled()){
			Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.saveSoccerEventDetails {0}",System.currentTimeMillis() - millis));
		}
		return soccerEvent;
	}

	private SoccerEvent getSimpleDataModel() {
		try{
			SoccerEvent soccerEvent = new SoccerEvent();
			soccerEvent.setHomeTeam(webDriver.findElement(By.xpath("//div[@class='qa-home-team']")).getText());
			soccerEvent.setAwayTeam(webDriver.findElement(By.xpath("//div[@class='qa-away-team']")).getText());
			return soccerEvent;
		}catch(Exception  exception){
			return null;
		}
	}

	private SoccerEvent getScoreboardDataMode1() {
		try{
			SoccerEvent soccerEvent = new SoccerEvent();
			String scoreBoardText = webDriver.findElement(By.xpath("//div[@class='liveScoreboardWidget']")).getText();
			String[] scoreBoardTextSplitted = scoreBoardText.split(SkybetConstants.REGULAR_EXPRESSIONS_END_OF_LINE) ;
			soccerEvent.setHomeTeam(scoreBoardTextSplitted[0]);
			soccerEvent.setAwayTeam(scoreBoardTextSplitted[1]);	
			return soccerEvent;
		}catch(Exception  exception){
			return null;
		}
	}

	@Override
	public List<String> getLinks(String url) {
		Long millis = System.currentTimeMillis();
		webDriver.navigate().to(url);
		List<String> links = new ArrayList<>();
		List<WebElement> divOverviewWebElements = webDriver
				.findElements(By.xpath(SkybetConstants.XPATH_EVENTLIST_DETAIL_LINK));
		for (WebElement webElement : divOverviewWebElements) {
			links.add(webElement.getAttribute("href"));
		}
		if(Loggers.root.isInfoEnabled()){
			Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.getLinks {0}", System.currentTimeMillis() - millis));
		}
		return links;
	}

	@Override
	public List<String> clickNationsToGetCompetitions(String url) {
		Long millis = System.currentTimeMillis();
		webDriver.navigate().to(url);
		webDriver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		boolean found = false;
		List<String> links = new ArrayList();
		List<WebElement> sideMenuSections = webDriver
				.findElements(By.xpath("//div[@class='sideMenuSection']"));
		for (WebElement sideMenuSection : sideMenuSections) {
			List<WebElement> sideMenuSectionTtiles = sideMenuSection
					.findElements(By.xpath("//div[@class='sideMenuSection__title']"));
			for (WebElement sideMenuSectionTtile : sideMenuSectionTtiles) {
				if ("Tutte Le Competizioni".equalsIgnoreCase(sideMenuSectionTtile.getText()) && !found) {
					found = true;
					List<WebElement> linksExploded = sideMenuSectionTtile
							.findElements(By.xpath("//div[@class='sideMenuGroup__title']"));
					for (WebElement linkExploded : linksExploded) {
						List<WebElement> spans = linkExploded
								.findElements(By.xpath("//span[@class='sideMenuGroup__titleIcon']"));
						for (WebElement span : spans) {
							span.click();
						}

						List<WebElement> linksDiv = linkExploded.findElements(By.xpath(
								"//div[@class='sideMenuGroup__links']//ul[@class='linkList']//li[@class='linkList__item']//a[@class='linkList__link']"));
						for (WebElement linkDiv : linksDiv) {
							links.add(linkDiv.getAttribute("href"));
						}
						return links;
					}
				}
			}
		}
		if(Loggers.performance.isInfoEnabled()){
			Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.clickNationsToGetCompetitions {0}",System.currentTimeMillis() - millis));
		}
		return links;
	}

	@Override
	public  Map<String,String>  getSoccerEventLinks(String url) {
		Long millis = System.currentTimeMillis();
		Map<String,String> map = new  HashMap<>();
		webDriver.navigate().to(url);
		List<WebElement> divOverviewWebElements = webDriver
				.findElements(By.xpath(SkybetConstants.XPATH_TITLE_CARD));
		for (WebElement webElement : divOverviewWebElements) {
			if("Sabato 12 Maggio".equals(webElement.getText())){
				List<WebElement> hrefs = webElement.findElements(By.xpath(".//div[@class='eventlist__table']//div[@class='qa-eventlist']//div[@class='eventListEvents__container']//div[@class='eventListEvents__details']//div//div[@class='eventListEventDetail__container']" + SkybetConstants.XPATH_EVENTLIST_DETAIL_LINK));
				for (WebElement webElement2 : hrefs) {
					String[] splitted = webElement2.getText().split(SkybetConstants.REGULAR_EXPRESSIONS_END_OF_LINE);
					map.put(webElement2.getAttribute("href"),splitted[splitted.length-1]);
					if(Loggers.root.isDebugEnabled()){
						Loggers.root.debug("Today Event Found:" + webElement2.getAttribute("href"));
					}
				}	
			}
		}
		if(Loggers.performance.isInfoEnabled()){
			Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.getSoccerEventLinks {0}", System.currentTimeMillis() - millis));
		}
		return map;
	}

	@Override
	public void saveLiveEventDetails(String url) {
		try{
			Long millis = System.currentTimeMillis();
			
			SoccerEvent soccerEvent = soccerEventBM.findById(url);
			if(soccerEvent == null){
				soccerEvent = initSoccerEvent(url,null);
			}else{
				webDriver.navigate().to(url);
			}
			
			String liveTIme = getLiveTime();

			String[] score = getScore().split("-");
			
			
			if(soccerEvent.getSoccerEventStatus() == SoccerEventStatus.ONLY_LINK){
				soccerEvent.setSoccerEventStatus(SoccerEventStatus.LIVE);
			}
				
			
			Map<Integer, String> idsAndTitles = getIdsAndTitlesToAnalyze();
			List<Odd> odds = retrieveOddsFromPage(idsAndTitles);
			
			LiveOdds liveOdds = new LiveOdds();
			if(liveTIme != null){
				liveOdds.setMinute(new BigDecimal(liveTIme.replaceAll(":", ".")));
			}else{
				liveTIme = getLiveTime();
			}
			liveOdds.setHomeGoals(Integer.valueOf(score[0]));
			liveOdds.setAwayGoals(Integer.valueOf(score[1]));
			liveOdds.setOdds(odds);
			liveOdds.setInsertDate(new Date());
			if(soccerEvent.getLiveOdds() == null){
				soccerEvent.setLiveOdds(new ArrayList<>());
			}
			soccerEvent.getLiveOdds().add(liveOdds);
			//if(terminata){
//				SoccerEventArchive soccerEventArchive = new SoccerEventArchive();
//				BeanUtils.copyProperties(soccerEvent, soccerEventArchive);
//				soccerEventArchiveBM.save(soccerEventArchive);
//				soccerEventBM.delete(soccerEvent);
			//}else{
			soccerEvent.setModifyDate(new Date());
			soccerEventBM.save(soccerEvent);
				
			//}
			if(Loggers.performance.isInfoEnabled()){
				Loggers.performance.info(MessageFormat.format("SoccerEventBMImpl.saveSoccerEventDetails {0}",System.currentTimeMillis() - millis));
			}
		}catch(Exception exception){
			if(Loggers.root.isWarnEnabled()){
				Loggers.root.warn("unable to save live event: " + url,exception);	
			}
		}
	}

	private String getScore() {
		
		for (int i = 0;i<=1;i++){
			try{
				switch (i) {
				case 0:
					WebElement element = webDriver
							.findElement(By.xpath(SkybetConstants.XPATH_SCORECONTENT));
					String[] standardScore = getScore(element.getText()).split("-");
					boolean terminata = isTerminata(element.getText());
					Integer homeGoals = Integer.parseInt(standardScore[0]);
					Integer awayGoals = Integer.parseInt(standardScore[1]);
					return homeGoals + "-" + awayGoals;
				case 1:
					return webDriver.findElement(By.xpath(SkybetConstants.XPATH_SCORECONTENT_HOME_TEAM)).getText() + "-" + webDriver.findElement(By.xpath(SkybetConstants.XPATH_SCORECONTENT_AWAY_TEAM)).getText();

				}
			}catch(Exception exception){
				
			}
			
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	private String getLiveTime() {
		String ret = null;
		
		List<String> clockPaths = Arrays.asList(SkybetConstants.XPATH_LIVETIME,SkybetConstants.XPATH_LIVETIME_SIMPLE,SkybetConstants.XPATH_LIVETIME_CLOCK,SkybetConstants.XPATH_INFO_WRAPER);
		for (String clockPath: clockPaths) {
			try{
				ret = webDriver
				.findElement(By.xpath(clockPath)).getText();
				if(ret != null){
					return ret;
				}
			}catch(Exception exception){
				Loggers.root.warn("problem solving time " + clockPath + " ");
			}	
		}
		
		return ret;
	}

	private boolean isTerminata(String text) {
		String[] splitted = text.split(SkybetConstants.REGULAR_EXPRESSIONS_END_OF_LINE);
		for (int i = 0;i<splitted.length;i++) {
			if("Terminata".equals(splitted[i])){
				return true;
			}
		}
		return false;
	}

	private String getScore(String text) {
		String[] splitted = text.split(SkybetConstants.REGULAR_EXPRESSIONS_END_OF_LINE);
		for (int i = 0;i<splitted.length;i++) {
			if(":".equals(splitted[i])){
				return splitted[i-1] + "-" + splitted[i+1];
			}
		}
		return text;
	}

	private List<Odd> retrieveOddsFromPage(Map<Integer,String> idsAndTitles) {
		List<WebElement> quoteElements = webDriver
				.findElements(By.xpath(SkybetConstants.XPATH_EVENTLIST));
		
		Odd odd = null;
		List<Odd> odds = new ArrayList<>();
		for (Entry<Integer, String> entry : idsAndTitles.entrySet()) {
			String[] splitted = quoteElements.get(entry.getKey()).getText().split(SkybetConstants.REGULAR_EXPRESSIONS_END_OF_LINE);
			for (int i = 0; i < splitted.length; i++) {
				try {
					if (i % 2 == 0) {
						odd = new Odd();
						odd.setParent(idsAndTitles.get(entry.getKey()));
						odd.setKey(splitted[i]);
					} else {
						odd.setValue(new BigDecimal(splitted[i].replace(',', '.')));
						
						odds.add(odd);
					}
				} catch (Exception exception) {
					Loggers.root.warn("exception creating odd", exception);
					odd = new Odd();
				}
			}
		}
		return odds;
	}

	private Map<Integer, String> getIdsAndTitlesToAnalyze() {
		Map<Integer, String> idsAndTitles = new HashMap<>();
		List<String> eventsToAnalyze = eventsToAnalyzeBM.findAllAsStrings();
		List<WebElement> quoteTitles = webDriver
				.findElements(By.xpath(SkybetConstants.XPATH_TITLE_CARD));

		for (int i = 0; i < quoteTitles.size(); i++) {
			String eventToAnalyze = quoteTitles.get(i).getText();
			if (eventsToAnalyze.contains(eventToAnalyze)) {
				idsAndTitles.put(i, eventToAnalyze);
			}
		}
		return idsAndTitles;
	}



}
