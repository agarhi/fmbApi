package com.fmb.api.model;

import com.fmb.api.db.entity.Menu;

public class MenuRsvp {
	
	private Menu menu;
	private String size;
	private Boolean lessCarbs;
	private Integer adultCount;
	private Integer kidCount;
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Boolean getLessCarbs() {
		return lessCarbs;
	}
	public void setLessCarbs(Boolean lessCarbs) {
		this.lessCarbs = lessCarbs;
	}
	public Integer getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}
	public Integer getKidCount() {
		return kidCount;
	}
	public void setKidCount(Integer kidCount) {
		this.kidCount = kidCount;
	}
	
	
	
}
