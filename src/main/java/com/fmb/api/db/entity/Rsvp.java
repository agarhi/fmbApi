package com.fmb.api.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Rsvp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_id")
	private Menu menu;
		
	private String size;
	
	@Column(name="less_carbs")
	private boolean lessCarbs;
	
	@Column(name="adult_count")
	private int adultCount;
	
	@Column(name="kids_count")
	private int kidsCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public boolean isLessCarbs() {
		return lessCarbs;
	}

	public void setLessCarbs(boolean lessCarbs) {
		this.lessCarbs = lessCarbs;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getKidsCount() {
		return kidsCount;
	}

	public void setKidsCount(int kidsCount) {
		this.kidsCount = kidsCount;
	}

	@Override
	public String toString() {
		return "Rsvp [id=" + id + ", user=" + user + ", menu=" + menu + ", size=" + size + ", lessCarbs=" + lessCarbs
				+ ", adultCount=" + adultCount + ", kidsCount=" + kidsCount + "]";
	}
	
	
}