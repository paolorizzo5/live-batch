package com.paolorizzo.betting.bet_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({
	"com.paolorizzo.betting.live_batch.skybet",
	"com.paolorizzo.betting.bet_bot",
	"com.paolorizzo.bet_bot_mongo",
	"com.paolorizzo.bet_bot_mysql",
	"com.paolorizzo.bet_bot_mysql.data.dao",
	"com.paolorizzo.bet_bot.mysql.data.mappers"
	
})
@Configuration
@EnableAutoConfiguration
@EnableCaching
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
