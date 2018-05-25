package com.paolorizzo.commons.entities;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4296550703459300482L;

	private Integer code;

	private String message;

	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(Integer code, String message) {
		super();
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
