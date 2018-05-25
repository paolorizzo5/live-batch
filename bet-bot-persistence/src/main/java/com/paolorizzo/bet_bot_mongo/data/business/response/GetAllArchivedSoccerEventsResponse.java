package com.paolorizzo.bet_bot_mongo.data.business.response;

import java.io.Serializable;
import java.util.List;

import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;
import com.paolorizzo.commons.entities.ErrorMessage;
import com.paolorizzo.commons.entities.RestResponse;

public class GetAllArchivedSoccerEventsResponse extends RestResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3895307606610310033L;
	
	private List<SoccerEventArchive> soccerEvents;

	public GetAllArchivedSoccerEventsResponse() {
		super();
	}
	
	public GetAllArchivedSoccerEventsResponse(boolean success,List<ErrorMessage> errorMessages,List<SoccerEventArchive> soccerEvents) {
		super(success,errorMessages);
		this.soccerEvents = soccerEvents;
	}
	
	public List<SoccerEventArchive> getSoccerEvents() {
		return soccerEvents;
	}

	public void setSoccerEvents(List<SoccerEventArchive> soccerEvents) {
		this.soccerEvents = soccerEvents;
	}

}
