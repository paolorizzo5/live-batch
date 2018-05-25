package com.paolorizzo.betting.bet_bot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.paolorizzo.bet_bot_mysql.data.business.UserBM;
import com.paolorizzo.bet_bot_mysql.data.business.response.UserLoginResponse;
import com.paolorizzo.bet_bot_mysql.data.model.User;

/**
 * Created by luhuiguo on 2017/4/13.
 */
@RestController
@RequestMapping("/users")
public class UserREST {

	@Autowired
	UserBM userBM;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		UserLoginResponse userLoginResponse  = userBM.login(user);
		return ResponseEntity.ok().body(new Gson().toJson(userLoginResponse));
	}
}
