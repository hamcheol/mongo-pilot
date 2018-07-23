package com.slowhand.mongo.pilot.enums;

public enum ReceiverType implements CodeEnum, TextEnum {
	RCVTP_001("RCVTP_001", "아이디"),
	RCVTP_002("RCVTP_002", "휴대폰"),
	
	RCVTP_003("RCVTP_003", "카카오톡"),
	RCVTP_004("RCVTP_004", "마이그레이션"),
	;
	
	private ReceiverType(String code, String text) {
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