package com.fmb.api.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_preference")
public class Preference {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private ThaliSize size;
	
	@Column(name="less_carbs")
	private boolean lessCarbs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ThaliSize getSize() {
		return size;
	}
	public void setSize(ThaliSize size) {
		this.size = size;
	}
	public boolean isLessCarbs() {
		return lessCarbs;
	}
	public void setLessCarbs(boolean lessCarbs) {
		this.lessCarbs = lessCarbs;
	}
	
	
}
