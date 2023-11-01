package com.fmb.api.service;

import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SignUpRequest;

public interface UserService {
	public void register(SignUpRequest signUpRequest) throws FmbException;

}
