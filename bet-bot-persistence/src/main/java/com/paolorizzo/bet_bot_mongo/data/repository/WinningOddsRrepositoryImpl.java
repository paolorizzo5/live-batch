package com.paolorizzo.bet_bot_mongo.data.repository;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;
import com.paolorizzo.bet_bot_mongo.data.model.WinningOdds;
import com.paolorizzo.bet_bot_mongo.data.model.ids.WinningOddsId;

@Component
public class WinningOddsRrepositoryImpl implements WinningOddsRrepository {

	@Autowired
    MongoTemplate mongoTemplate;
	
	
	@Override
	public List<WinningOdds> findAll() {
		return mongoTemplate.findAll(WinningOdds.class);
	}

	@Override
	public List<WinningOdds> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> List<S> saveAll(Iterable<S> arg0) {
		for (S s : arg0) {
			mongoTemplate.save(s);
		}
		return (List<S>) arg0;
	}

	@Override
	public Page<WinningOdds> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(WinningOdds arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends WinningOdds> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(WinningOddsId arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(WinningOddsId arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<WinningOdds> findAllById(Iterable<WinningOddsId> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<WinningOdds> findById(WinningOddsId arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> S save(S arg0) {
		Long millis = System.currentTimeMillis();
		mongoTemplate.save(arg0);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("WinningOddsRrepository.save={0}",System.currentTimeMillis() - millis));
		return arg0;
	}

	@Override
	public <S extends WinningOdds> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends WinningOdds> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends WinningOdds> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends WinningOdds> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
