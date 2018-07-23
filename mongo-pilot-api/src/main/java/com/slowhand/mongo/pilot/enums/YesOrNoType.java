package com.slowhand.mongo.pilot.enums;

public enum YesOrNoType implements CodeEnum, TextEnum {
	Y("Y", "Yes"),
	N("N", "No")
	;
	
	private String code;
	private String text;
	
	private YesOrNoType(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getCode() {
		return code;
	}
	
	/**
	 * value와 YesOrNoType값들의 code와 비교해서 일치하는게 있으면 YesOrNoType을 반환.
	 * 없다면 기본값을 반환한다.
	 * @param value
	 * @param defaultValue
	 * @return
	 */
	public static YesOrNoType getValue(String value, YesOrNoType defaultValue) {
		for(YesOrNoType one : values()) {
			if(one.getCode().equalsIgnoreCase(value)) {
				return one;
			}
		}
		return defaultValue;
	}
}
