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
import com.paolorizzo.bet_bot_mongo.data.model.FinishedEvent;

@Component
public class FinishedEventRepositoryImpl implements FinishedEventRepository{

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public List<FinishedEvent> findAll() {
		Long millis = System.currentTimeMillis();
		List<FinishedEvent>  ret = mongoTemplate.findAll(FinishedEvent.class);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("FinishedEventRepository.findAll={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public List<FinishedEvent> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FinishedEvent> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FinishedEvent> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FinishedEvent> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FinishedEvent> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FinishedEvent> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<FinishedEvent> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(FinishedEvent arg0) {
		Long millis = System.currentTimeMillis();
		DeleteResult deleteResult = mongoTemplate.remove(arg0);
		deleteResult.getDeletedCount();
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("FinishedEventRepository.delete {0}",System.currentTimeMillis() - millis));
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends FinishedEvent> arg0) {
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
	public Iterable<FinishedEvent> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FinishedEvent> findById(String id) {
		Long millis = System.currentTimeMillis();
		Optional<FinishedEvent> ret = Optional.ofNullable(mongoTemplate.findById(id, FinishedEvent.class));
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("Optional<FinishedEvent> findById={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public <S extends FinishedEvent> S save(S arg0) {
		Long millis = System.currentTimeMillis();
		mongoTemplate.save(arg0);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("Optional<FinishedEvent> save={0}",System.currentTimeMillis() - millis));
		return arg0;
	}

	@Override
	public <S extends FinishedEvent> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends FinishedEvent> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends FinishedEvent> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends FinishedEvent> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
