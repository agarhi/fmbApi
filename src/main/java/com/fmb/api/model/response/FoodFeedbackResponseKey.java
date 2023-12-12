package com.fmb.api.model.response;

import java.sql.Date;
import java.util.Objects;

import com.fmb.api.db.entity.FoodFeedback;

public class FoodFeedbackResponseKey {
	private Date date;
	private String item;
	
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
	
	public static FoodFeedbackResponseKey from(FoodFeedback foodFeedback) {
		FoodFeedbackResponseKey feedbackResponse = new FoodFeedbackResponseKey();
		feedbackResponse.setDate(foodFeedback.getMenu().getDate());
		feedbackResponse.setItem(foodFeedback.getMenu().getItem());
		return feedbackResponse;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, item);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodFeedbackResponseKey other = (FoodFeedbackResponseKey) obj;
		return Objects.equals(date, other.date) && Objects.equals(item, other.item);
	}
	
	@Override
	public String toString() {
		return item + " - " + date;
	}
}