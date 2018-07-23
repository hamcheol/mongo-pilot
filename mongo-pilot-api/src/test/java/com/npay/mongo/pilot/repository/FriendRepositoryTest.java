package com.npay.mongo.pilot.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import com.slowhand.mongo.pilot.model.Friend;
import com.slowhand.mongo.pilot.model.User;
import com.slowhand.mongo.pilot.repository.FriendRepository;
import com.slowhand.mongo.pilot.utils.PrintUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void findByEmbeddedField() {
		List<User> users = friendRepository.findByFriendsNid("ikjYyMe");
		for(User u : users) {
			logger.info(PrintUtils.prettyPrint(u));
		}
		
		List<Friend> fs = friendRepository.findFriendsByFriendsNid("ikjYyMe");
		for(Friend f : fs) {
			logger.info(PrintUtils.prettyPrint(f));
		}
	}
	
	@Test
	public void partialFindByEmbeddedField() {
		Query query = Query.query(Criteria.where("friends.nid").is("ikjYyMe"));
		List<User> fs = mongoTemplate.find(query, User.class, "test");
		
		for(User f : fs) {
			logger.info(PrintUtils.prettyPrint(f));
		}
	}
	
	@Test
	public void partialUpdateEmbeddedField() {
		Query query = Query.query(Criteria.where("friends.nid").is("ikjYyMe"));
		Update update = Update.update("friends.$.lastModDate", LocalDateTime.now());
		UpdateResult result = mongoTemplate.updateMulti(query, update, User.class);
		if(result.getModifiedCount() > 0) {
			logger.info("exist");
		} else {
			logger.info("not exist");
		}
	}

}
