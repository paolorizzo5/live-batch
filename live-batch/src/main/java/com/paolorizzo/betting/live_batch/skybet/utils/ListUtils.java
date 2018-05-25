package com.paolorizzo.betting.live_batch.skybet.utils;

import java.util.List;

public class ListUtils {
	
	private ListUtils() {
		
	}

	public static void addifNotIn(List<String> links, String attribute) {
		if(!links.contains(attribute)){
			links.add(attribute);
		}
	}

}
