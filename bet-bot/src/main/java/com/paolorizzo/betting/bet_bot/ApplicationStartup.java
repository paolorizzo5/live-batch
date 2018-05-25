package com.paolorizzo.betting.bet_bot;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mysql.data.business.JobConfigurationBM;
import com.paolorizzo.bet_bot_mysql.data.model.JobConfiguration;
import com.paolorizzo.betting.bet_bot.constants.CronExpression;
import com.paolorizzo.betting.bet_bot.jobs.LiveEventPickerJob;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	JobConfigurationBM jobConfigurationBM;

	/**
	 * This event is executed as late as conceivably possible to indicate that
	 * the application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		quartzInit();
		return;
	}

	private void quartzInit() {

		jobConfigurationBM.clear();

		List<JobConfiguration> jobConfigurations = new ArrayList<JobConfiguration>();
		jobConfigurations.add(new JobConfiguration(LiveEventPickerJob.class.getSimpleName(),
				CronExpression.EVERY_MINUTE, "live", LiveEventPickerJob.class.getName(), null));

		for (JobConfiguration jobConfiguration : jobConfigurations) {
			jobConfigurationBM.insert(jobConfiguration);
		}
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();

			List<JobConfiguration> jobConfigurationsList = jobConfigurationBM.list();
			for (JobConfiguration jobConfiguration : jobConfigurationsList) {

				JobDetail jobDetail = JobBuilder
						.newJob((Class<? extends Job>) Class.forName(jobConfiguration.getClassName()))
						.withIdentity(jobConfiguration.getName(), jobConfiguration.getJobGroup()).build();

				Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity(jobConfiguration.getName() + "Trigger", jobConfiguration.getJobGroup())
						.withSchedule(CronScheduleBuilder.cronSchedule(jobConfiguration.getCronExpression())).build();

				scheduler.scheduleJob(jobDetail, trigger);

			}
		} catch (ClassNotFoundException e) {
			Loggers.root.error("",e);
		} catch (SchedulerException e) {
			Loggers.root.error("",e);
		}

	}

} // class