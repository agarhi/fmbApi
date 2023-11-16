package com.fmb.api.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fmb.api.model.request.SignUpRequest;

@Entity
@Table(name="user_preference")
public class Preference {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String size;
	
	@Column(name="less_carbs")
	private boolean lessCarbs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isLessCarbs() {
		return lessCarbs;
	}
	public void setLessCarbs(boolean lessCarbs) {
		this.lessCarbs = lessCarbs;
	}
	
	public static Preference from(SignUpRequest signUpRequest) {
		Preference preference = new Preference();
		preference.setSize(signUpRequest.getSize());
		preference.setLessCarbs(signUpRequest.isLessCarbs());
		return preference;
	}
	
	
}
