package com.paolorizzo.bet_bot_mysql.data.business;

import com.paolorizzo.bet_bot_mysql.data.business.response.UserLoginResponse;
import com.paolorizzo.bet_bot_mysql.data.model.User;

public interface UserBM {
	
	boolean logout(String email);

	UserLoginResponse login(User user);

	
}
