package com.paolorizzo.betting.live_batch.intralot;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.paolorizzo.betting.live_batch.constants.IntralotConstants;
import com.paolorizzo.betting.live_batch.model.LiveMatchDetail;

@Component
public class BetGeniusParser {

	public LiveMatchDetail parseLiveStats(WebDriver driver,LiveMatchDetail liveMatchDetail) {
		liveMatchDetail.setHomeGoals(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-scoreboard-entities-Scoreboard-HomeGoals']")).getText()));
		liveMatchDetail.setAwayGoals(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-scoreboard-entities-Scoreboard-AwayGoals']")).getText()));
		liveMatchDetail.setTime(driver.findElement(By.xpath("//div[@class='time time-horizontal-header']")).getText().replaceAll(":", "."));
		String hs = driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-HomeTotalShots']")).getText();
		
		WebElement element = driver.findElement(By.className("ui-football-statistics-entities-FootballStatistics"));
		int timeout = 10;
        while(timeout > 0 && element.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-AwayTotalShots']")).getText().isEmpty()) {
			element = driver.findElement(By.className("ui-football-statistics-entities-FootballStatistics"));
			if(timeout > 0) {
                timeout--;
                try {
                    Thread.sleep(10);
                } catch(Exception e) {
                	System.out.println("empty");
                }
            }
        }
        //TODO
//		liveMatchDetail.setHomeShotsTotal(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-HomeTotalShots']")).getText()));
//		liveMatchDetail.setAwayShotsTotal(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-AwayTotalShots']")).getText()));
//		
//		liveMatchDetail.setHomeRedCards(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-HomeRedCards']")).getText()));
//		liveMatchDetail.setAwayRedCards(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-AwayRedCards']")).getText()));
		
//		liveMatchDetail.setHomeAttacks(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-HomeAttacks']")).getText()));
//		liveMatchDetail.setAwayAttacks(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-AwayAttacks']")).getText()));
//	
//		liveMatchDetail.setHomeDangerousAttacks(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-HomeDangerousAttacks']")).getText()));
//		liveMatchDetail.setAwayDangerousAttacks(Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-football-statistics-entities-FootballStatistics-AwayDangerousAttacks']")).getText()));
//		
		return liveMatchDetail;
	}

	public LiveMatchDetail parseMatchInfo(WebDriver driver,LiveMatchDetail liveMatchDetail) {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='betgenius-iframe']"));
		driver.switchTo().frame(iframe);
		liveMatchDetail.setHomeTeam(driver.findElement(By.xpath("//span[@class='ui-football-scoreboard-entities-Scoreboard-HomeTeamName']")).getText());
		liveMatchDetail.setAwayTeam(driver.findElement(By.xpath("//span[@class='ui-football-scoreboard-entities-Scoreboard-AwayTeamName']")).getText());
		return liveMatchDetail;
	}

	public LiveMatchDetail parseLiveQuotes(WebDriver driver, LiveMatchDetail liveMatchDetail) {
		driver = driver.switchTo().defaultContent();
		WebElement quoteElement =  driver.findElement(By.xpath("//table[@class='quote']"));
		List<WebElement> trs =  quoteElement.findElements(By.xpath("//tr"));
		for (WebElement webElement : trs)  {
			if(!StringUtils.isEmpty(webElement.getText())){
				
				List<WebElement> tds = webElement.findElements(By.xpath("//td[@class='liveClueTip2']"));
				
				for (WebElement td : tds) {
					System.out.println("tdtext: resultId=" + td.getAttribute("resultId") + " value=" + td.getText());
				}
				
				
				
				String[] splittedData = StringUtils.split(webElement.getText(), "\r\n");
				if(splittedData != null){
					String title = splittedData[0];
					
					if(IntralotConstants._QUOTE_NEXT_GOAL_LIST.contains(title)){//segna prossimo goal
						//calculateNextGoal(liveMatchDetail);
						
						for (int i = 1;i<splittedData.length;i++){
							if(i % 2 == 1){
								switch (splittedData[i]) {
								case "1":
									liveMatchDetail.setNextGoalScoredByHomeTeam(new BigDecimal(splittedData[i+1]));
								case "2":
									liveMatchDetail.setNextGoalScoredByAwayTeam(new BigDecimal(splittedData[i+1]));
									break;
								default:
									liveMatchDetail.setNextGoalScoredByNoTeam(new BigDecimal(splittedData[i+1]));
									break;
								}
							}
						}
						calculateNextGoal(liveMatchDetail);
						
					//	System.out.println(IntralotConstants._QUOTE_NEXT_GOAL_LIST);
					}else if(IntralotConstants._QUOTE_GOAL_NOGOAL.equals(title)){//goal no-goal
						
					}else if(IntralotConstants._QUOTE_GOAL_HOME.equals(title)){//segna goal squdra di casa
						
					}else if(IntralotConstants._QUOTE_GOAL_AWAY.equals(title)){//segna goal squadra trasferta
						
					}else if(IntralotConstants._QUOTE_GOAL_COUNT.equals(title)){//segna goal totale
						
					}
					System.out.println("--------------------------------------------------------------");
					System.out.println(webElement.getText());
				}
				
			}
		}
		return liveMatchDetail;
	}
	
	/**
	 * questo metodo si occupa di calcolare la convenienza sull'evento di prossimo goal
	 * @param liveMatchDetail
	 */
	private void calculateNextGoal(LiveMatchDetail liveMatchDetail) {
		Integer totalGoalsScored = liveMatchDetail.getHomeGoals() + liveMatchDetail.getAwayGoals();
		
		
		if(totalGoalsScored == 0){
			//da approfondire
		}else{
			BigDecimal time = new BigDecimal(liveMatchDetail.getTime());
			BigDecimal goalFrequency = time.divide(new BigDecimal(totalGoalsScored));
			BigDecimal timeRemaining = new BigDecimal(90).subtract(time);
			
			if(timeRemaining.compareTo(goalFrequency) > 0){
				//probabile che si segni un altro goal.... ma da approfondire
			}else{
				//probabile che non si segni un altro goal.... ma da approfondire
			}
		}
		
			
	}

}
