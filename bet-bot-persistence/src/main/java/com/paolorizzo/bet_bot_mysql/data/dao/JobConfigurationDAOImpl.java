package com.paolorizzo.bet_bot_mysql.data.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mysql.data.model.JobConfiguration;
import com.paolorizzo.betting.bet_bot.mappers.JobConfigurationMAPPER;

@Component
public class JobConfigurationDAOImpl implements JobConfigurationDAO {
	
	@Autowired
	JobConfigurationMAPPER JobConfigurationMAPPER;

	@Override
	public boolean clear() {
		return JobConfigurationMAPPER.clear() >= 0;
	}

	@Override
	public int count() {
		return JobConfigurationMAPPER.count();
	}

	@Override
	public boolean insert(JobConfiguration jobConfiguration) {
		return JobConfigurationMAPPER.insert(jobConfiguration) > 0;
	}

	@Override
	public List<JobConfiguration> list() {
		return JobConfigurationMAPPER.list();
	}

}
