package com.fmb.api.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fmb.api.model.request.SpInstructionsRequest;

@Entity
@Table(name="special_instructions")
public class SpecialInstructions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	private Date date;
	private String instructions;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public static SpecialInstructions from(SpInstructionsRequest spInstructionsRequest) {
		SpecialInstructions specialInstructions = new SpecialInstructions();
		specialInstructions.setInstructions(spInstructionsRequest.getInstructions());
		specialInstructions.setDate(spInstructionsRequest.getSqlDate());
		return specialInstructions;
	}
	
	public static SpecialInstructions withEmptyInstructions(String date) {
		SpecialInstructions specialInstructions = new SpecialInstructions();
		specialInstructions.setInstructions("No special Instructions");
		specialInstructions.setDate(Date.valueOf(date));
		return specialInstructions;
	}
	
}
