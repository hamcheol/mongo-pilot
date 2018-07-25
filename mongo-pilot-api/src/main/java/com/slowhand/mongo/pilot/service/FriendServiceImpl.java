package com.slowhand.mongo.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slowhand.mongo.pilot.model.entity.User;
import com.slowhand.mongo.pilot.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendRepository friendRepository;

	@Override
	public void save(User user) {
		friendRepository.save(user);
	}

	@Override
	public void bulkSave(List<User> users) {
		friendRepository.saveAll(users);
	}

	@Override
	public User getUserAndFriends(String id) {
		return friendRepository.findByNid(id);
	}

}
