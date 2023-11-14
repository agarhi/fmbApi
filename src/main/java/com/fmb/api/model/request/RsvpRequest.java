package com.fmb.api.model.request;

import java.util.Set;

public class RsvpRequest {
	
	private int userId;
	private Set<Integer> menuIds; // To be used for things like RSVP all
	private int menuId; // This will be used in case we want to update one record like for size or less carbs
	private boolean choice;
	private int offset;
	private String size;
	private boolean lessCarbsChoice;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Set<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(Set<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	public boolean isChoice() {
		return choice;
	}
	public void setChoice(boolean choice) {
		this.choice = choice;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public boolean isLessCarbsChoice() {
		return lessCarbsChoice;
	}
	public void setLessCarbsChoice(boolean lessCarbsChoice) {
		this.lessCarbsChoice = lessCarbsChoice;
	}
	
	
}
