package com.paolorizzo.bet_bot_mongo.data.model;

import java.math.BigDecimal;

public class Odd{
	
	private String parent;
	private String key;
	private BigDecimal value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}

}
