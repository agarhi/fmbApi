package com.fmb.api.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_raza_status")
public class RazaStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String aamil;
	
	@Column(name="raza_recd")
	private boolean razaReceived;
	
	@Column(name="requested_date")
	private Timestamp requestDate;
	
	@Column(name="approved_date")
	private Timestamp approvedDate;
	
	@Column(name="rejected_date")
	private Timestamp rejectedDate;
	
	@Column(name="reject_reason")
	private String rejectReason;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAamil() {
		return aamil;
	}
	public void setAamil(String aamil) {
		this.aamil = aamil;
	}
	public boolean isRazaReceived() {
		return razaReceived;
	}
	public void setRazaReceived(boolean razaReceived) {
		this.razaReceived = razaReceived;
	}
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	public Timestamp getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Timestamp approvedDate) {
		this.approvedDate = approvedDate;
	}
	public Timestamp getRejectedDate() {
		return rejectedDate;
	}
	public void setRejectedDate(Timestamp rejectedDate) {
		this.rejectedDate = rejectedDate;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
	

}
