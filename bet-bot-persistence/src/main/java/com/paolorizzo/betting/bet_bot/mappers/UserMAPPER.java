package com.paolorizzo.betting.bet_bot.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.paolorizzo.bet_bot_mysql.data.model.User;

@Mapper
public interface UserMAPPER {
	
	@Select("SELECT EMAIL FROM USERS WHERE EMAIL = #{email} and PASSWORD = #{password}")
	User login(User user);
	

}
