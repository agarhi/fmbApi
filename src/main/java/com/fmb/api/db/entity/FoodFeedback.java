package com.fmb.api.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fmb.api.model.request.FeedbackRequest;

@Entity
@Table(name="feedback")
public class FoodFeedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String quality;
	
	private String comment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_item")
	private Menu menu;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user", nullable = true)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static FoodFeedback from(FeedbackRequest feedbackRequest) {
		FoodFeedback feedback = new FoodFeedback();
		feedback.setComment(feedbackRequest.getComment());
		feedback.setQuality(feedbackRequest.getQuality());
		return feedback;
	}
}