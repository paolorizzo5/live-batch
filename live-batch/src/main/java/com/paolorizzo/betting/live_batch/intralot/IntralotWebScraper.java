package com.paolorizzo.betting.live_batch.intralot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.paolorizzo.betting.live_batch.model.LiveMatchDetail;
import com.paolorizzo.betting.live_batch.model.SingleMatchInfo;

@Component
public class IntralotWebScraper {

	WebDriver driver;
	

	/**
	 * 
	 * @param username
	 * @param Password
	 * 
	 *            Logins into the website, by entering provided username and
	 *            password
	 */
	public void login(String username, String Password) {

		WebElement userName_editbox = driver.findElement(By.id("usr"));
		WebElement password_editbox = driver.findElement(By.id("pwd"));
		WebElement submit_button = driver.findElement(By.xpath("//input[@value='Login']"));

		userName_editbox.sendKeys(username);
		password_editbox.sendKeys(Password);
		submit_button.click();

	}

	/**
	 * grabs the status text and saves that into status.txt file
	 * 
	 * @throws IOException
	 */
	public List<SingleMatchInfo> parseMainPage(String url) throws IOException {
		driver.navigate().to(url);
		List<SingleMatchInfo> infos = new ArrayList<SingleMatchInfo>();
		List<WebElement> divOverviewWebElements = driver.findElements(By.xpath("//li[@sport='1']"));
		for (WebElement webElement : divOverviewWebElements) {
			List<WebElement> trLiveEventTRElements = webElement.findElements(By.xpath("//tr[@class='liveEventTR']"));
			for (WebElement trLiveEventTRElement : trLiveEventTRElements) {
				List<WebElement> trLiveEventTDColonna6Elemeents = trLiveEventTRElement.findElements(By.xpath("//td[@class='colonna6']"));
				for (WebElement trLiveEventTDColonna6Elemeent : trLiveEventTDColonna6Elemeents) {
					try{
						String matchId = trLiveEventTDColonna6Elemeent.getAttribute("matchId");
						infos.add(new SingleMatchInfo(matchId));
					}catch(Exception exception){
						
					}
					
				}
				return infos;
			}
		}
		return infos;

	}

	private void parseDetailPage(SingleMatchInfo singleMatchInfo) {
		try{
			LiveMatchDetail liveMatchDetail = new LiveMatchDetail();
			driver.navigate().to("https://www.intralot.it/scommesseliveevento?matchid=" + singleMatchInfo.getMatchId());
			
			try{
				betRadar(liveMatchDetail,singleMatchInfo.getMatchId());
			}catch(Exception exception){
				betGenius(liveMatchDetail,singleMatchInfo.getMatchId());
			}
			
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	private void betRadar(LiveMatchDetail liveMatchDetail, String id) {
		
		liveMatchDetail.setHomeTeam(driver.findElement(By.xpath("//span[@id='ctl00_plcMain_ucEventDetail_lblTeam1']")).getText());
		liveMatchDetail.setAwayTeam(driver.findElement(By.xpath("//span[@id='ctl00_plcMain_ucEventDetail_lblTeam2']")).getText());
		
		WebElement divstats =  driver.findElement(By.xpath("//div[@class='sr-matchstats']"));
		List<WebElement> quotes = divstats.findElements(By.xpath("//table[@class='quote_brmid_" + id + "']"));
        
		List<WebElement> webElements = divstats.findElements(By.xpath("//div[@class='sr-stats-wrapper']"));
		System.out.println(divstats.getText());
		
		String[] matchStats = StringUtils.split(divstats.getText(),"\r\n");
		
		for (int i = 6;i<matchStats.length;i = i + 3){
			
		}
		
		
	}

	private void betGenius(LiveMatchDetail liveMatchDetail, String id) throws Exception{
		BetGeniusParser betGeniusParser = new BetGeniusParser();
		
		//parsing delle informazioni generali del match
		liveMatchDetail  = betGeniusParser.parseMatchInfo(driver,liveMatchDetail);
		
		//parsing delle statistiche live
		//liveMatchDetail  = betGeniusParser.parseLiveStats(driver,liveMatchDetail);

		//parsing delle quote live
		liveMatchDetail  = betGeniusParser.parseLiveQuotes(driver,liveMatchDetail);
		
		//interrogaziono motoe regole
		System.out.println(liveMatchDetail.toString());

	}

	

	/**
	 * Saves the screenshot
	 * 
	 * @throws IOException
	 */
	public void saveScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
	}

	public void closeBrowser() {
		driver.close();
	}

	public String getPage(String url) throws IOException {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("javascript.enabled", false);
	    driver = new FirefoxDriver(firefoxOptions);
		List<SingleMatchInfo> singleMatchInfos = parseMainPage(url);
		for (SingleMatchInfo singleMatchInfo : singleMatchInfos) {
			parseDetailPage(singleMatchInfo);
		}
		
		//webSrcapper.saveScreenshot();
		closeBrowser();
		return "";
	}
}