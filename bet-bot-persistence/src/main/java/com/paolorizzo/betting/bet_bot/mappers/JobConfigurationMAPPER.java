package com.paolorizzo.betting.bet_bot.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.paolorizzo.bet_bot_mysql.data.model.JobConfiguration;

@Mapper
public interface JobConfigurationMAPPER {

	@Delete("DELETE FROM JOB_CONFIGURATIONS")
	int clear();

	@Select("SELECT COUNT(*) FROM JOB_CONFIGURATIONS")
	int count();

	@Insert("INSERT INTO JOB_CONFIGURATIONS "
			+ "(NAME,CLASS_NAME,CRON_EXPRESSION,JOB_GROUP,LAST_EXECUTION) "
			+ "VALUES "
			+ "(#{name},#{className},#{cronExpression},#{jobGroup},#{lastExecution})")
	int insert(JobConfiguration jobConfiguration);

	@Select("SELECT NAME,CRON_EXPRESSION,JOB_GROUP,CLASS_NAME,LAST_EXECUTION FROM JOB_CONFIGURATIONS")
	List<JobConfiguration> list();
}
