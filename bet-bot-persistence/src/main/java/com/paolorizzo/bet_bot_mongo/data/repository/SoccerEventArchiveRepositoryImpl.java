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
import com.paolorizzo.bet_bot_mongo.data.model.SoccerEventArchive;

@Component
public class SoccerEventArchiveRepositoryImpl implements SoccerEventArchiveRepository{

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Override
	public List<SoccerEventArchive> findAll() {
		Long millis = System.currentTimeMillis();
		List<SoccerEventArchive> ret = mongoTemplate.findAll(SoccerEventArchive.class);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("List<SoccerEventArchive> findAll={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public List<SoccerEventArchive> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEventArchive> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEventArchive> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEventArchive> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEventArchive> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEventArchive> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SoccerEventArchive> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(SoccerEventArchive arg0) {
		Long millis = System.currentTimeMillis();
		mongoTemplate.remove(arg0);
		if(Loggers.mongo.isInfoEnabled()) Loggers.mongo.info(MessageFormat.format("SoccerEventArchivedelete={0}",System.currentTimeMillis() - millis));
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends SoccerEventArchive> arg0) {
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
	public Iterable<SoccerEventArchive> findAllById(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SoccerEventArchive> findById(Long id) {
		Long millis = System.currentTimeMillis();
		Optional<SoccerEventArchive> ret = Optional.of(mongoTemplate.findById(id, SoccerEventArchive.class));
		Loggers.mongo.info(MessageFormat.format("Optional<SoccerEventArchive> findById={0}",System.currentTimeMillis() - millis));
		return ret;
	}

	@Override
	public <S extends SoccerEventArchive> S save(S arg0) {
		Long millis = System.currentTimeMillis();
		mongoTemplate.save(arg0);
		return arg0;
	}

	@Override
	public <S extends SoccerEventArchive> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends SoccerEventArchive> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends SoccerEventArchive> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends SoccerEventArchive> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
