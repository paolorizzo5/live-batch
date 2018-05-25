package com.paolorizzo.bet_bot_mongo.data.business;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.enums.Bettypes;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.Bettype;
import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;
import com.paolorizzo.bet_bot_mongo.data.model.ids.WinningOddsId;
import com.paolorizzo.bet_bot_mongo.data.repository.WinningOddsRrepository;

@Component
@CacheConfig(cacheNames = "winningOddsCache")
public class WinningOddsBMImpl implements WinningOddsBM{

	@Autowired
	WinningOddsRrepository winningOddsRrepository;

	@Override
	public boolean isEmpty() {
		Long millis = System.currentTimeMillis();
		long count = winningOddsRrepository.count();
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("WinningOddsBMImpl.IsEmpty {0}" , System.currentTimeMillis() - millis));
		return count == 0;
	}

	@Override
	public void init() {
		for (int homeGoals = 0;homeGoals < 10; homeGoals ++){
			for (int awayGoals = 0;awayGoals < 10; awayGoals ++){
				
				WinningOdds winningOdds = new WinningOdds();
				winningOdds.setWinningOddsId(new WinningOddsId(homeGoals,awayGoals));
				List<Bettype> bettypes = new ArrayList<>();
				
				if(homeGoals == awayGoals){
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_1X2_X));
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_DOPPIACHANCE_1X));
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_DOPPIACHANCE_X2));
				}else if(homeGoals > awayGoals){
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_1X2_1));
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_DOPPIACHANCE_1X));
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_DOPPIACHANCE_12));
				}else{
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_1X2_2));
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_DOPPIACHANCE_X2));
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_DOPPIACHANCE_12));
				}
				
				if(homeGoals < 0 && awayGoals > 0){
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_GOALNOGOAL_GOAL));
				}else{
					bettypes.add(Bettypes.convert(Bettypes.BETTYPE_GOALNOGOAL_NOGOAL));
				}
				
				winningOdds.setBettypes(bettypes);
				winningOddsRrepository.save(winningOdds);
			}
				
		}
	}

	@Override
	public WinningOdds get(Integer homeGoals, Integer awayGoals) {
		Long millis = System.currentTimeMillis();
		Optional<WinningOdds> optional = winningOddsRrepository.findById(new WinningOddsId(homeGoals, awayGoals));
		if(Loggers.performance.isInfoEnabled()) Loggers.performance.info(MessageFormat.format("WinningOddsBMImpl.get={0}" , System.currentTimeMillis() - millis));
		if(optional.isPresent()){
			return optional.get();
		}else{
			return null;
		}
	}
	
		
	
}
