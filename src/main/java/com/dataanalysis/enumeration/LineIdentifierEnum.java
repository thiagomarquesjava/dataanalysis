package com.dataanalysis.enumeration;

public enum LineIdentifierEnum {

	SELLER("001"),
	CLIENT("002"),
	SALES("003");

	private String code;
	
	private LineIdentifierEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}