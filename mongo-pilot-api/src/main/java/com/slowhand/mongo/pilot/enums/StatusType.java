package com.slowhand.mongo.pilot.enums;

public enum StatusType implements CodeEnum, TextEnum {
	ALIVE("ALIVE", "정상"),
	REMOVE("REMOVE", "탈퇴"),
	;
	
	private StatusType(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	private String code;
	private String text;

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getCode() {
		return code;
	}
}