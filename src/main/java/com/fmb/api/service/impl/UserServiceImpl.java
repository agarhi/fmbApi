package com.fmb.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.User;
import com.fmb.api.db.repo.UserRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SignUpRequest;
import com.fmb.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void register(SignUpRequest signUpRequest) throws FmbException {
		try {
			logger.info(signUpRequest.toString());
			User user = User.from(signUpRequest);
			logger.info(user.toString());
			userRepository.save(user);
		} catch (DataIntegrityViolationException dive) {
			logger.error(dive.getMessage());
			throw new FmbException("Non unique values");
		} 
		catch(Exception e) {
			logger.error("Name "+e.getClass().getName());
			throw new FmbException("System error");
		}
		

	}

}
