package com.paolorizzo.betting.live_batch.skybet.model;

import org.openqa.selenium.WebDriver;

import com.paolorizzo.betting.live_batch.skybet.enums.WebDriverStatus;

public class WebDriverCustom {
	
	private WebDriver webDriver;
	
	private WebDriverStatus webDriverStatus;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriverStatus getWebDriverStatus() {
		return webDriverStatus;
	}

	public void setWebDriverStatus(WebDriverStatus webDriverStatus) {
		this.webDriverStatus = webDriverStatus;
	}
	
	

}
