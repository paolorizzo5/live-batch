package com.paolorizzo.bet_bot_mongo.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.paolorizzo.bet_bot_mongo.data.model.EventsToAnalyze;

@Component
public class EventsToAnalyzeRrepositoryImpl implements EventsToAnalyzeRrepository {

	@Autowired
    MongoTemplate mongoTemplate;
	
	
	@Override
	public List<EventsToAnalyze> findAll() {
		return mongoTemplate.findAll(EventsToAnalyze.class);
	}

	@Override
	public List<EventsToAnalyze> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> List<S> saveAll(Iterable<S> arg0) {
		for (S s : arg0) {
			mongoTemplate.save(s);
		}
		return (List<S>) arg0;
	}

	@Override
	public Page<EventsToAnalyze> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(EventsToAnalyze arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends EventsToAnalyze> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<EventsToAnalyze> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EventsToAnalyze> findById(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends EventsToAnalyze> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends EventsToAnalyze> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EventsToAnalyze> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
