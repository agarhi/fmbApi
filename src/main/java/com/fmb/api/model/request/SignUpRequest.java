package com.fmb.api.model.request;

public class SignUpRequest {
	private String fname;
	private String lname;
	private String its;
	private String addr1;
	private String addr2;
	private String city;
	private String zip;
	private String state;
	private String country;
	private String phone;
	private String email;
	private String userid;
	private String password;
	private String role;
	
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
	public String getIts() {
		return its;
	}
	public void setIts(String its) {
		this.its = its;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "SignUpRequest [fname=" + fname + ", lname=" + lname + ", its=" + its + ", addr1=" + addr1 + ", addr2="
				+ addr2 + ", city=" + city + ", zip=" + zip + ", state=" + state + ", country=" + country + ", phone="
				+ phone + ", email=" + email + ", userid=" + userid + ", password=" + password + "]";
	}
	
	
}
