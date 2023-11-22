package com.fmb.api.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.SpecialInstructions;
import com.fmb.api.db.repo.SpInstructionsRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SpInstructionsRequest;
import com.fmb.api.service.SpInstructionsService;

@Service
public class SpInstructionsServiceImpl implements SpInstructionsService {
	
	@Autowired
	private SpInstructionsRepository spInstructionsRepository;

	@Override
	public void save(SpInstructionsRequest spInstructionsRequest) throws FmbException {
		SpecialInstructions spInstructions = spInstructionsRepository.findById(spInstructionsRequest.getId()).orElse(null);
		if(spInstructions == null) {
			spInstructions = SpecialInstructions.from(spInstructionsRequest);
			
		} else {
			spInstructions.setInstructions(spInstructionsRequest.getInstructions());
		}
		spInstructionsRepository.save(spInstructions);

	}

	@Override
	public void saveAll(List<SpInstructionsRequest> spInstructionsRequest) throws FmbException {
		List<SpecialInstructions> listToSave = new ArrayList<>();
		for(SpInstructionsRequest instructionsRequest : spInstructionsRequest) {
			SpecialInstructions spInstructions = SpecialInstructions.from(instructionsRequest);
			listToSave.add(spInstructions);
		}
		spInstructionsRepository.saveAll(listToSave);
	}

	@Override
	public SpecialInstructions getByDate(String date) throws FmbException {
		SpecialInstructions ins = spInstructionsRepository.getByDate(Date.valueOf(date));
		if(ins == null) {
			ins = SpecialInstructions.withEmptyInstructions(date);
		}
		return ins;
	}

}
