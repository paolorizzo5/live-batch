package com.paolorizzo.betting.live_batch.utils;

import java.util.Calendar;

public class DateUtils {

	public static Integer getTomorrowDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.get(Calendar.DAY_OF_MONTH) + 1;
	}

}
