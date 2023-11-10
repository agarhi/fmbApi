package com.fmb.api.model.response;

import java.sql.Date;

import com.fmb.api.model.MenuRsvp;

public class RsvpResponse {
	private Date date;
	private boolean rsvp;
	private MenuRsvp menuRsvp;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isRsvp() {
		return rsvp;
	}
	public void setRsvp(boolean rsvp) {
		this.rsvp = rsvp;
	}
	public MenuRsvp getMenuRsvp() {
		return menuRsvp;
	}
	public void setMenuRsvp(MenuRsvp menuRsvp) {
		this.menuRsvp = menuRsvp;
	}
	
	
}
