package com.slowhand.mongo.pilot.service;

import java.util.List;

import com.slowhand.mongo.pilot.model.entity.User;

public interface FriendService {
	public void save(User user);
	public void bulkSave(List<User> users);
	public User getUserAndFriends(String id);
}
