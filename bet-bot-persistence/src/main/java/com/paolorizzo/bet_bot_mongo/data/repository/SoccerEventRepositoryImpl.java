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

import com.mongodb.client.result.DeleteResult;
import com.paolorizzo.bet_bot_mongo.data.logging.Loggers;
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEvent;

@Component
public class SoccerEventRepositoryImpl implements SoccerEventRepository{

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public List<SoccerEvent> findAll() {
		Long millis = System.currentTimeMillis();
		List<SoccerEvent>  ret = mongoTemplate.findAll(SoccerEvent.class);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("SoccerEventRepository.findAll={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public List<SoccerEvent> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEvent> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEvent> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEvent> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEvent> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEvent> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SoccerEvent> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(SoccerEvent arg0) {
		Long millis = System.currentTimeMillis();
		DeleteResult deleteResult = mongoTemplate.remove(arg0);
		deleteResult.getDeletedCount();
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("SoccerEventRepository.delete {0}",System.currentTimeMillis() - millis));
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends SoccerEvent> arg0) {
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
	public Iterable<SoccerEvent> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SoccerEvent> findById(String id) {
		Long millis = System.currentTimeMillis();
		Optional<SoccerEvent> ret = Optional.ofNullable(mongoTemplate.findById(id, SoccerEvent.class));
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("Optional<SoccerEvent> findById={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public <S extends SoccerEvent> S save(S arg0) {
		Long millis = System.currentTimeMillis();
		mongoTemplate.save(arg0);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("Optional<SoccerEvent> save={0}",System.currentTimeMillis() - millis));
		return arg0;
	}

	@Override
	public <S extends SoccerEvent> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends SoccerEvent> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends SoccerEvent> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEvent> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
