package com.paolorizzo.betting.bet_bot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolorizzo.bet_bot_mysql.data.business.UserBM;

/**
 * Created by luhuiguo on 2017/4/13.
 */
@RestController
@RequestMapping("/api")
public class HelloResource {

	@Autowired
	UserBM userBM;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok().body("Hello World!");
	}
}
