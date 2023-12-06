package com.fmb.api.service;

import java.util.List;
import java.util.Set;

import com.fmb.api.db.entity.FoodFeedback;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.FeedbackRequest;

public interface FoodFeedbackService {
	List<FoodFeedback> getByMenuIds(Set<Integer> menuIds) throws FmbException;

	void save(FeedbackRequest feedbackRequest);
}
