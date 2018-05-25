package com.paolorizzo.bet_bot_mysql.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mysql.data.model.User;
import com.paolorizzo.betting.bet_bot.mappers.UserMAPPER;

@Component
public class UserDAOImpl implements UserDAO{

	@Autowired
	UserMAPPER userMAPPER;
	
	@Override
	public User login(User user) {
		return userMAPPER.login(user);
	}

}
