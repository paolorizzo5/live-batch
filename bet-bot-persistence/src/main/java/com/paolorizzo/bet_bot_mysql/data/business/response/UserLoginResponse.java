package com.paolorizzo.bet_bot_mysql.data.business.response;

import java.io.Serializable;
import java.util.List;

import com.paolorizzo.bet_bot_mysql.data.model.User;
import com.paolorizzo.commons.entities.ErrorMessage;
import com.paolorizzo.commons.entities.RestResponse;


public class UserLoginResponse extends RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6833328758396263320L;
	private User user;
	
	
	public UserLoginResponse() {
		super();
	}
	
	public UserLoginResponse(Boolean success,List<ErrorMessage> errorMessages,User user) {
		super(success,errorMessages);
		this.setUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
