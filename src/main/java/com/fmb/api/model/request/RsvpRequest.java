package com.fmb.api.model.request;

import java.util.Set;

public class RsvpRequest {
	
	private int userId;
	private Set<Integer> menuIds;
	private boolean choice;
	private int offset;
	
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
	
	
}
