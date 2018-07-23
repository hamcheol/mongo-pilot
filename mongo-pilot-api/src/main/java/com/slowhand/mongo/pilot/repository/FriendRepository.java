package com.slowhand.mongo.pilot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.slowhand.mongo.pilot.model.Friend;
import com.slowhand.mongo.pilot.model.User;

public interface FriendRepository extends MongoRepository<User, String> {
	
	public List<User> findByFriendsNid(String nid);
	
	public List<Friend> findFriendsByFriendsNid(String nid);
	
}
