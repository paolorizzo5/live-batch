package com.paolorizzo.commons.enums;

public enum ErrorCodes {
	
	LOGIN_ERROR(1,"login.error"),
	GETALLMATCHES_ERROR(2,"getallmatches.error"),
	
	
	GENERIC_ERROR(9999,"generic.error")
	;
	
	Integer code;
	
	String message;
	
	ErrorCodes(Integer code,String message){
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
