package com.fmb.api.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fmb.api.model.request.SignUpRequest;

@Entity
@Table(name="user_credentials")
public class Credentials {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userid;
	private String password;
	private int role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public static Credentials from(SignUpRequest signUpRequest) {
		Credentials credentials = new Credentials();
		credentials.setUserid(signUpRequest.getUserid());
		credentials.setPassword(signUpRequest.getPassword());
		credentials.setRole(1);
		return credentials;
	}
	
	
}
