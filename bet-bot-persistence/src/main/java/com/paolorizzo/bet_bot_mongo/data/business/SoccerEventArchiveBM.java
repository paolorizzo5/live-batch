package com.paolorizzo.bet_bot_mongo.data.business;

import java.util.List;

import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;

public interface SoccerEventArchiveBM {

	SoccerEventArchive save(SoccerEventArchive soccerEventArchive);

	SoccerEventArchive findById(Long id);

	List<SoccerEventArchive> findAll();

	void delete(SoccerEventArchive soccerEventArchive);

	void detail(SoccerEventArchive soccerEventArchive);

}
