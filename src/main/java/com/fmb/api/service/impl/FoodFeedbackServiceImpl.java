package com.fmb.api.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.FoodFeedback;
import com.fmb.api.db.repo.FoodFeedbackRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.service.FoodFeedbackService;

@Service
public class FoodFeedbackServiceImpl implements FoodFeedbackService {
	
	@Autowired
	private FoodFeedbackRepository feedbackRepository;

	@Override
	public List<FoodFeedback> getByMenuIds(Set<Integer> menuIds) throws FmbException {
		return feedbackRepository.getByMenuIds(menuIds);
	}

}
