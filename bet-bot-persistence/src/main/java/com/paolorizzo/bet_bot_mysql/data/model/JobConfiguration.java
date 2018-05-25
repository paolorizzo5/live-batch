package com.paolorizzo.bet_bot_mysql.data.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class JobConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6001949494378713730L;

	private String name;

	private String cronExpression;

	private String jobGroup;

	private String className;

	private Date lastExecution;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getLastExecution() {
		return lastExecution;
	}

	public void setLastExecution(Date lastExecution) {
		this.lastExecution = lastExecution;
	}

	public JobConfiguration(String name, String cronExpression, String jobGroup, String className, Date lastExecution) {
		super();
		this.name = name;
		this.cronExpression = cronExpression;
		this.jobGroup = jobGroup;
		this.className = className;
		this.lastExecution = lastExecution;
	}
	
	//costruttore per @Mapper
	public JobConfiguration(String name, String cronExpression, String jobGroup, String className, Timestamp lastExecution) {
		super();
		this.name = name;
		this.cronExpression = cronExpression;
		this.jobGroup = jobGroup;
		this.className = className;
		this.lastExecution = lastExecution;
	}

	
}
