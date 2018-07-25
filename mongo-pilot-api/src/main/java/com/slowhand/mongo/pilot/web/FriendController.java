package com.slowhand.mongo.pilot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slowhand.mongo.pilot.model.entity.User;
import com.slowhand.mongo.pilot.model.response.UserResponse;
import com.slowhand.mongo.pilot.service.FriendService;

@RestController
public class FriendController {
	@Autowired
	private FriendService friendService;
	
	@RequestMapping("/{id}/friends")
	public ResponseEntity<UserResponse> list(@PathVariable String id) {
		User user = friendService.getUserAndFriends(id);
		return new ResponseEntity<>(new UserResponse(user), HttpStatus.OK);
	}
}
