package com.fmb.api.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fmb.api.model.request.SignUpRequest;

@Entity
@Table(name="user_contact")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static Address from(SignUpRequest signUpRequest) {
		Address addr = new Address();
		addr.setLine1(signUpRequest.getAddr1());
		addr.setLine2(signUpRequest.getAddr2());
		addr.setCity(signUpRequest.getCity());
		addr.setZip(signUpRequest.getZip());
		addr.setState(signUpRequest.getState());
		addr.setCountry(signUpRequest.getCountry());
		addr.setPhone(signUpRequest.getPhone());
		addr.setEmail(signUpRequest.getEmail());
		return addr;
		
	}
}
