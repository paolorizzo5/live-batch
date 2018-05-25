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
import com.paolorizzo.bet_bot_mongo.data.model.Bettype;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;

@Component
public class BettypeRrepositoryImpl implements BettypeRrepository {

	@Autowired
    MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Bettype> findAll() {
		return mongoTemplate.findAll(Bettype.class);
	}

	@Override
	public List<Bettype> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> List<S> saveAll(Iterable<S> arg0) {
		for (S s : arg0) {
			mongoTemplate.save(s);
		}
		return (List<S>) arg0;
	}

	@Override
	public Page<Bettype> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		Long millis = System.currentTimeMillis();
		long ret = mongoTemplate.findAll(Bettype.class).size();
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("BettypeRepository.count={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public void delete(Bettype arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Bettype> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Bettype> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Bettype> findById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> S save(S arg0) {
		Long millis = System.currentTimeMillis();
		mongoTemplate.save(arg0);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("BettypeRepository.save={0}",System.currentTimeMillis() - millis));
		return arg0;
	}

	@Override
	public <S extends Bettype> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Bettype> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Bettype> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bettype> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
