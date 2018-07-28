package com.slowhand.mongo.pilot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.slowhand.mongo.pilot.model.entity.Sequence;

public class FriendCustomRepositoryImpl implements FriendCustomRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public long incrementAndGetFriendSeq() {
		Query query = Query.query(Criteria.where("_id").is("friendseq"));
		Update update = new Update();
		update.inc("seq", 1);
		return mongoTemplate.findAndModify(query, update, Sequence.class).getSeq();
	}

}
