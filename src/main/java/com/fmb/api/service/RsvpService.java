package com.fmb.api.service;

import java.util.List;

import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.response.RsvpResponse;

public interface RsvpService {
	public List<RsvpResponse> getByUserIdAndMenuOffset(int userid, int offset) throws FmbException;
}
