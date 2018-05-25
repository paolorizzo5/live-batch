package com.paolorizzo.commons.entities;

import java.io.Serializable;
import java.util.List;

public class RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1589491848518190561L;
	private Boolean success;
	private List<ErrorMessage> errorMessages;

	public RestResponse() {
		// TODO Auto-generated constructor stub
	}

	public RestResponse(Boolean success, List<ErrorMessage> errorMessages) {
		super();
		this.success = success;
		this.errorMessages = errorMessages;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<ErrorMessage> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<ErrorMessage> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
