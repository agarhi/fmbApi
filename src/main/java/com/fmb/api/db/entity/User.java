package com.fmb.api.db.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fmb.api.model.request.SignUpRequest;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	private String fname;
	private String lname;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credentials_id")
	private Credentials credentials;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "raza_status_id")
	private RazaStatus razaStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preference_id")
	private Preference preference;
	
	private String its;
	
	private int thalinum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getIts() {
		return its;
	}
	public void setIts(String its) {
		this.its = its;
	}
	
	public RazaStatus getRazaStatus() {
		return razaStatus;
	}
	public void setRazaStatus(RazaStatus razaStatus) {
		this.razaStatus = razaStatus;
	}
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	public int getThalinum() {
		return thalinum;
	}
	public void setThalinum(int thalinum) {
		this.thalinum = thalinum;
	}
	
	public static User from(SignUpRequest signUpRequest) {
		User user = new User();
		user.setFname(signUpRequest.getFname());
		user.setLname(signUpRequest.getLname());
		user.setIts(signUpRequest.getIts());
		user.setCreatedDate(new Timestamp(new Date().getTime()));
		
		RazaStatus razaStatus = RazaStatus.from(signUpRequest);
		user.setRazaStatus(razaStatus);
		
		Address addr = Address.from(signUpRequest);
		user.setAddress(addr);
		
		Credentials creds = Credentials.from(signUpRequest);
		user.setCredentials(creds);
		
		Preference preference =  Preference.from(signUpRequest);
		user.setPreference(preference);
		
		return user;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", createdDate=" + createdDate + ", fname=" + fname + ", lname=" + lname
				+ ", credentials=" + credentials + ", address=" + address + ", razaStatus=" + razaStatus
				+ ", preference=" + preference + ", its=" + its + ", thalinum=" + thalinum + "]";
	}
	
	
	
	
	
}