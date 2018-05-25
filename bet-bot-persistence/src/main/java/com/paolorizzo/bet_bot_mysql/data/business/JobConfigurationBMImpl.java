package com.paolorizzo.bet_bot_mysql.data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paolorizzo.bet_bot_mysql.data.dao.JobConfigurationDAO;
import com.paolorizzo.bet_bot_mysql.data.model.JobConfiguration;

@Service
public class JobConfigurationBMImpl implements JobConfigurationBM{

	
	@Autowired
	JobConfigurationDAO jobConfigurationDAO;

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		return jobConfigurationDAO.clear();
	}

	@Override
	public int count() {
		return jobConfigurationDAO.count();
	}

	@Override
	public boolean insert(JobConfiguration jobConfiguration) {
		return jobConfigurationDAO.insert(jobConfiguration);
	}

	@Override
	public List<JobConfiguration> list() {
		return jobConfigurationDAO.list();
	}
	
	
}
