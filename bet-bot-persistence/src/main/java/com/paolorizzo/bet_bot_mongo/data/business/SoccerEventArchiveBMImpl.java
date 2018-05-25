package com.paolorizzo.bet_bot_mongo.data.business;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.Bettype;
import com.paolorizzo.bet_bot_mongo.data.model.LiveOdds;
import com.paolorizzo.bet_bot_mongo.data.model.Odd;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;
import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;
import com.paolorizzo.bet_bot_mongo.data.repository.SoccerEventArchiveRepository;

@Component
public class SoccerEventArchiveBMImpl implements SoccerEventArchiveBM{
	
	@Autowired
	SoccerEventArchiveRepository soccerEventArchiveRepository;
	
	@Autowired
	WinningOddsBM winningOddsBM;
	
	@Override
	public SoccerEventArchive save(SoccerEventArchive soccerEventArchive) {
		Long millis = System.currentTimeMillis();
		SoccerEventArchive ret = soccerEventArchiveRepository.save(soccerEventArchive);
		Loggers.performance.info(MessageFormat.format("SoccerEventArchiveBMImpl.save {0}" , System.currentTimeMillis() - millis));
		return ret;
	}
	
	@Override
	public SoccerEventArchive findById(Long id) {
		Long millis = System.currentTimeMillis();
		SoccerEventArchive ret = null;
		Optional<SoccerEventArchive> optional = soccerEventArchiveRepository.findById(id);
		if(optional.isPresent()){
			ret = optional.get();
		}else{
			ret = new SoccerEventArchive();
		}
		Loggers.performance.info(MessageFormat.format("SoccerEventArchiveBMImpl.findById {0}" , System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public List<SoccerEventArchive> findAll() {
		Long millis = System.currentTimeMillis();
		List<SoccerEventArchive> ret = soccerEventArchiveRepository.findAll();
		Loggers.performance.info(MessageFormat.format("SoccerEventArchiveBMImpl.findAll {0}" , System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public void delete(SoccerEventArchive soccerEventArchive) {
		Long millis = System.currentTimeMillis();
		soccerEventArchiveRepository.delete(soccerEventArchive);
		Loggers.performance.info(MessageFormat.format("SoccerEventArchiveBMImpl.delete {0}" , System.currentTimeMillis() - millis));
	}

	@Override
	public void detail(SoccerEventArchive soccerEventArchive) {
		WinningOdds winningOdds = winningOddsBM.get(soccerEventArchive.getHomeGoals(),soccerEventArchive.getAwayGoals());
		for (Bettype bettype : winningOdds.getBettypes()) {
			Double bestOdd = getBestOdd(soccerEventArchive,bettype);
			
		}
	}

	private Double getBestOdd(SoccerEventArchive soccerEventArchive, Bettype bettype) {
	
		for (LiveOdds liveOdds : soccerEventArchive.getLiveOdds()) {
			for (Odd odd : liveOdds.getOdds()) {
				if(odd.getParent().equals(bettype.getParent()) && odd.getKey().equals(bettype.getKey())){
					
				}
						
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	
}
