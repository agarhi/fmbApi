package com.fmb.api.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date date;
	private String item;
	private boolean niyaz;
	private boolean readonly;
	
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public boolean isNiyaz() {
		return niyaz;
	}
	public void setNiyaz(boolean niyaz) {
		this.niyaz = niyaz;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", date=" + date + ", item=" + item + ", niyaz=" + niyaz + ", readonly=" + readonly
				+ "]";
	}
	
}