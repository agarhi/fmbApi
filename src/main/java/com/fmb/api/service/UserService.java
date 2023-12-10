package com.fmb.api.service;

import java.util.List;

import com.fmb.api.db.entity.User;
import com.fmb.api.db.repo.UserRepository.PendingUserRaza;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SignUpRequest;

public interface UserService {
	public void register(SignUpRequest signUpRequest) throws FmbException;
	public User getByUsername(String username) throws FmbException;
	public List<PendingUserRaza> getPendingRaza() throws FmbException;

}
