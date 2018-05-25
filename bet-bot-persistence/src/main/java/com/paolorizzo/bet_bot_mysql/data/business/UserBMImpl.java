package com.paolorizzo.bet_bot_mysql.data.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.paolorizzo.bet_bot_mysql.data.business.response.UserLoginResponse;
import com.paolorizzo.bet_bot_mysql.data.dao.UserDAO;
import com.paolorizzo.bet_bot_mysql.data.model.User;
import com.paolorizzo.commons.entities.ErrorMessage;
import com.paolorizzo.commons.enums.ErrorCodes;

@Service
@PropertySource("classpath:config/messages.properties")
public class UserBMImpl implements UserBM {

	@Autowired
	UserDAO userDAO;

	@Autowired
	private Environment env;

	@Override
	public UserLoginResponse login(User user) {
		List<ErrorMessage> errorMessages = null;

		try {
			User ret = userDAO.login(user);
			if (ret == null) {
				errorMessages = Arrays.asList(new ErrorMessage(ErrorCodes.LOGIN_ERROR.getCode(),
						env.getProperty(ErrorCodes.LOGIN_ERROR.getMessage())));
			}
			return new UserLoginResponse(ret != null, errorMessages,ret);
		} catch (Exception exception) {
			errorMessages = Arrays.asList(new ErrorMessage(ErrorCodes.GENERIC_ERROR.getCode(),
					env.getProperty(ErrorCodes.GENERIC_ERROR.getMessage())));
			return new UserLoginResponse(false,errorMessages,null);
		}
		
	}

	@Override
	public boolean logout(String email) {
		// TODO
		return false;
	}

}
