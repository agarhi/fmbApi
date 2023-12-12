package com.fmb.api.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.FeedbackRequest;
import com.fmb.api.model.response.FoodFeedbackResponseKey;
import com.fmb.api.model.response.FoodFeedbackResponseValue;

public interface FoodFeedbackService {
	Map<FoodFeedbackResponseKey, List<FoodFeedbackResponseValue>> getByMenuIds(Set<Integer> menuIds) throws FmbException;

	void save(FeedbackRequest feedbackRequest);
}
