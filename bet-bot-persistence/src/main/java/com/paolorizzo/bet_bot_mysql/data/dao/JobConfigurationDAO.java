package com.paolorizzo.bet_bot_mysql.data.dao;

import java.util.List;

import com.paolorizzo.bet_bot_mysql.data.model.JobConfiguration;

public interface JobConfigurationDAO {
	
	boolean clear();

	int count();

	boolean insert(JobConfiguration jobConfiguration);

	List<JobConfiguration> list();

}
