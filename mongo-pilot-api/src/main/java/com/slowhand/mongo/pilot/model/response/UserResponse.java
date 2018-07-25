package com.slowhand.mongo.pilot.model.response;

import com.slowhand.mongo.pilot.model.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserResponse extends ApiResponse {
	private User user;
	
	public UserResponse(User user) {
		this.user = user;
	}

}
