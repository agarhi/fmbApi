package com.fmb.api.model.request;

import java.sql.Date;

public class SpInstructionsRequest {
	private int id;
	private String date;
	private String instructions;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Date getSqlDate() {
		return Date.valueOf(date);
	}
	
}
