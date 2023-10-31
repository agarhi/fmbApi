package com.fmb.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.User;
import com.fmb.api.db.repo.UserRepository;
import com.fmb.api.model.request.SignUpRequest;
import com.fmb.api.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void register(SignUpRequest signUpRequest) {
		logger.info(signUpRequest.toString());
		User user = User.from(signUpRequest);
		logger.info(user.toString());
		userRepository.save(user);

	}

}
