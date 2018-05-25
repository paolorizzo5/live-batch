package com.paolorizzo.betting.bet_bot.web;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.paolorizzo.bet_bot_mongo.data.business.SoccerEventArchiveBM;
import com.paolorizzo.bet_bot_mongo.data.business.SoccerEventBM;
import com.paolorizzo.bet_bot_mongo.data.business.WinningOddsBM;
import com.paolorizzo.bet_bot_mongo.data.business.response.GetAllArchivedSoccerEventsResponse;
import com.paolorizzo.bet_bot_mongo.data.business.response.GetSoccerEventDetailResponse;
import com.paolorizzo.bet_bot_mongo.data.exceptions.BusinessException;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;
import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;
import com.paolorizzo.bet_bot_mysql.data.business.UserBM;
import com.paolorizzo.bet_bot_mysql.data.model.User;
import com.paolorizzo.commons.entities.ErrorMessage;

/**
 * Created by luhuiguo on 2017/4/13.
 */
@RestController
@RequestMapping("/soccerevents")
public class SoccerEventREST {

	@Autowired
	UserBM userBM;

	@Autowired
	SoccerEventArchiveBM soccerEventArchiveBM;
	
	@Autowired
	WinningOddsBM winningOddsBM;
	
	@PostMapping("/getallarchived")
	public ResponseEntity<String> getAll(@RequestBody User user) {
		GetAllArchivedSoccerEventsResponse response = null;
		List<SoccerEventArchive> soccerEvents  = soccerEventArchiveBM.findAll();
		response  = new GetAllArchivedSoccerEventsResponse(true,null,soccerEvents);
		return ResponseEntity.ok().body(new Gson().toJson(response));
	}
	
	@PostMapping("/detail")
	public ResponseEntity<String> detail(@RequestBody SoccerEventArchive soccerEventArchive) {
		GetSoccerEventDetailResponse response = null;
		soccerEventArchiveBM.detail(soccerEventArchive);
		List<SoccerEventArchive> soccerEvents  = soccerEventArchiveBM.findAll();
		response  = new GetAllArchivedSoccerEventsResponse(true,null,soccerEvents);
		return ResponseEntity.ok().body(new Gson().toJson(response));
	}
}
