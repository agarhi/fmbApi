package com.fmb.api.service;

import java.util.List;
import java.util.Set;

import com.fmb.api.db.entity.FoodFeedback;
import com.fmb.api.error.handling.FmbException;

public interface FoodFeedbackService {
	List<FoodFeedback> getByMenuIds(Set<Integer> menuIds) throws FmbException;
}
