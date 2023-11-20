package com.fmb.api.db.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fmb.api.model.request.SignUpRequest;

@Entity
@Table(name="user_credentials")
public class Credentials {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@Column(name="userid")
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String role;
	
	@JsonIgnore
	private boolean accountNonExpired;
	
	@JsonIgnore
	private boolean credentialsNonExpired;
	
	@JsonIgnore
	private boolean accountNonLocked;
	
	@JsonIgnore
	private boolean enabled;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isEnabled() {
		return this.enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@JsonIgnore
	public List<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_".concat(role)));
	}
	
	public static Credentials from(SignUpRequest signUpRequest) {
		Credentials credentials = new Credentials();
		credentials.setUsername(signUpRequest.getUserid());
		String role = signUpRequest.getRole();
		credentials.setRole(role == null ? "USER" : role);
		credentials.setAccountNonExpired(true);
		credentials.setAccountNonLocked(true);
		credentials.setCredentialsNonExpired(true);
		credentials.setEnabled(true);
		return credentials;
	}
	
	
}
