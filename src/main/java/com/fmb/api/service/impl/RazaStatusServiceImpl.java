package com.fmb.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.RazaStatus;
import com.fmb.api.db.repo.RazaStatusRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.service.RazaStatusService;

@Service
public class RazaStatusServiceImpl implements RazaStatusService {
	
	@Autowired
	private RazaStatusRepository razaStatusRepository;
	@Override
	public RazaStatus getRazaStatus(String its) throws FmbException {
		try {
			return razaStatusRepository.getRazaStatus(its);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FmbException("System Error");
		}
		
	}

}
