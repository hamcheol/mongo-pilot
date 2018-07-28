package com.slowhand.mongo.pilot.model.response;

import lombok.Data;

@Data
public class ApiResponse<T> {
	private String message;
	private T body;
	
	public ApiResponse(T body, String message) {
		this.body = body;
		this.message = message;
	}

}
