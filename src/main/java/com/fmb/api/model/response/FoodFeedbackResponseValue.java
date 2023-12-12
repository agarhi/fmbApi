package com.fmb.api.model.response;

import com.fmb.api.db.entity.FoodFeedback;

public class FoodFeedbackResponseValue {
	
	private String quality;
	private String comment;
	private String username;
	private String its;
	
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIts() {
		return its;
	}
	public void setIts(String its) {
		this.its = its;
	}
	
	public static FoodFeedbackResponseValue from(FoodFeedback foodFeedback) {
		FoodFeedbackResponseValue feedbackResponse = new FoodFeedbackResponseValue();
		feedbackResponse.setQuality(foodFeedback.getQuality());
		feedbackResponse.setComment(foodFeedback.getComment());
		if(foodFeedback.getUser() != null) {
			feedbackResponse.setUsername(foodFeedback.getUser().getFname() + " "+foodFeedback.getUser().getLname());
			feedbackResponse.setIts(foodFeedback.getUser().getIts());
		} else {
			feedbackResponse.setUsername("Anonymous User");
			feedbackResponse.setIts("Not Applicable");
		}
		return feedbackResponse;
	}
	
	

}
