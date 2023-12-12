package com.fmb.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fmb.api.db.entity.FoodFeedback;
import com.fmb.api.db.entity.User;
import com.fmb.api.db.repo.FoodFeedbackRepository;
import com.fmb.api.db.repo.MenuRepository;
import com.fmb.api.db.repo.UserRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.FeedbackRequest;
import com.fmb.api.model.response.FoodFeedbackResponseKey;
import com.fmb.api.model.response.FoodFeedbackResponseValue;
import com.fmb.api.service.FoodFeedbackService;

@Service
public class FoodFeedbackServiceImpl implements FoodFeedbackService {
	
	@Autowired
	private FoodFeedbackRepository feedbackRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Map<FoodFeedbackResponseKey, List<FoodFeedbackResponseValue>> getByMenuIds(Set<Integer> menuIds) throws FmbException {
		Map<FoodFeedbackResponseKey, List<FoodFeedbackResponseValue>> responseMap = new HashMap<FoodFeedbackResponseKey, List<FoodFeedbackResponseValue>>();
		List<FoodFeedback> foodFeedbackList = feedbackRepository.getByMenuIds(menuIds);
		for(FoodFeedback foodFeedback : foodFeedbackList) {
			FoodFeedbackResponseKey feedbackResponseKey = FoodFeedbackResponseKey.from(foodFeedback);
			FoodFeedbackResponseValue feedbackResponseValue = FoodFeedbackResponseValue.from(foodFeedback);
			if(!responseMap.containsKey(feedbackResponseKey)) {
				List<FoodFeedbackResponseValue> list = new ArrayList<>();
				responseMap.put(feedbackResponseKey, list);
			}
			responseMap.get(feedbackResponseKey).add(feedbackResponseValue);
		}
		return responseMap;
	}

	@Override
	public void save(FeedbackRequest feedbackRequest) {
		FoodFeedback entity = FoodFeedback.from(feedbackRequest);
		if(!feedbackRequest.isAnonymous())
			entity.setUser(userRepository.findById(userId()).get());
		entity.setMenu(menuRepository.findById(feedbackRequest.getMenuId()).get());
		feedbackRepository.save(entity);
	}
	
	private HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
	
	private int userId() {
		int userId = ((User)session().getAttribute("CURRENT_USER")).getId();
		return userId;
	}
}
