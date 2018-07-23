package com.slowhand.mongo.pilot.enums;

public enum MemberStatusType implements CodeEnum, TextEnum {
	ALIVE("ALIVE", "정상"),
	REMOVE("REMOVE", "탈퇴"),
	
	;
	
	public static class Groups {
		public static final MemberStatusType[] IN_ACTIVE = {ALIVE};
	}
	
	private MemberStatusType(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	private String code;
	private String text;
	
	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String getText() {
		return text;
	}
}