package com.paolorizzo.betting.live_batch.skybet;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

import com.paolorizzo.betting.live_batch.skybet.enums.WebDriverStatus;
import com.paolorizzo.betting.live_batch.skybet.model.WebDriverCustom;

@Component
public class WebDriverManager {
	
	private List<WebDriverCustom> webDriverCustoms;
	
	public List<WebDriverCustom> getWebDriverCustoms() {
		return webDriverCustoms;
	}

	public void setWebDriverCustoms(List<WebDriverCustom> webDriverCustoms) {
		this.webDriverCustoms = webDriverCustoms;
	}

	public WebDriverCustom getAvailableDriverCustom(){
		synchronized (webDriverCustoms) {
			for (WebDriverCustom webDriverCustom : webDriverCustoms) {
				if(webDriverCustom.getWebDriverStatus() == WebDriverStatus.AVAILABLE){
					webDriverCustom.setWebDriverStatus(WebDriverStatus.BUSY);
					return webDriverCustom;
				}
			}
		}
		return null;
	}
	
	public void releaseDriver(WebDriverCustom webDriverCustom){
		webDriverCustom.setWebDriverStatus(WebDriverStatus.AVAILABLE);
	}
	
}
