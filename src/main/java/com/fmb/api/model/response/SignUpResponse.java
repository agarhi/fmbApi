package com.fmb.api.model.response;

public class SignUpResponse {
	
	private int status;
	private String successMessage;
	private String errorMessage;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public static SignUpResponse success() {
		SignUpResponse response = new SignUpResponse();
		response.setStatus(200);
		response.setSuccessMessage("User added");
		return response;
	}
	
}
