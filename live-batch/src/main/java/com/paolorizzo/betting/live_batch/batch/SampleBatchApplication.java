/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.paolorizzo.betting.live_batch.batch;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.paolorizzo.bet_bot_mongo.data.business.EventsToAnalyzeBM;
import com.paolorizzo.bet_bot_mongo.data.business.WinningOddsBM;
import com.paolorizzo.betting.live_batch.skybet.SkybetParser;
import com.paolorizzo.betting.live_batch.skybet.SkybetWebScraper;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({
		"com.paolorizzo.betting.live_batch.skybet",
		"com.paolorizzo.betting.live_batch.livescore",
		"com.paolorizzo.betting.live_batch.tasks",
		"com.paolorizzo.bet_bot_mongo.data.repository",
		"com.paolorizzo.bet_bot_mongo.data.business"
})
@EnableScheduling
@EnableCaching
public class SampleBatchApplication {

	
//	@Autowired
//	private JobBuilderFactory jobs;
//
//	@Autowired
//	private StepBuilderFactory steps;
//	
	
	@Autowired
	SkybetParser skybetParser;

	@Autowired
	EventsToAnalyzeBM eventsToAnalyzeBM;

	@Autowired
	WinningOddsBM winningOddsBM;
	
	@Bean
	protected SkybetParser skybetParser(){
		return new SkybetParser();
	}
	
	@Bean
	protected SkybetWebScraper skybetWebScraper(){
		return new SkybetWebScraper();
	}

	@Bean
	protected WebDriver webDriver(){
//		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		firefoxOptions.setCapability("javascript.enabled", false);
//		return new FirefoxDriver(firefoxOptions);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("javascript.enabled", false);
		return new ChromeDriver(chromeOptions);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SampleBatchApplication.class, args);
	}

}
