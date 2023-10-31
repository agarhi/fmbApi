package com.fmb.api.db.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Timestamp date;
	private String item;
	private String menucol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getMenucol() {
		return menucol;
	}
	public void setMenucol(String menucol) {
		this.menucol = menucol;
	}
}