package com.fmb.api.service;

import java.util.List;

import com.fmb.api.db.entity.SpecialInstructions;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SpInstructionsRequest;

public interface SpInstructionsService {
	
	public void save(SpInstructionsRequest spInstructionsRequest) throws FmbException;
	public void saveAll(List<SpInstructionsRequest> spInstructionsRequest) throws FmbException;
	public SpecialInstructions getByDate(String date) throws FmbException;
}
