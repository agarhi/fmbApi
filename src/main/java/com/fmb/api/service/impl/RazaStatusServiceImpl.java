package com.fmb.api.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.RazaStatus;
import com.fmb.api.db.repo.RazaStatusRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.service.RazaStatusService;

@Service
public class RazaStatusServiceImpl implements RazaStatusService {
	
	private static final Logger logger = LoggerFactory.getLogger(RazaStatusServiceImpl.class);
	
	@Autowired
	private RazaStatusRepository razaStatusRepository;
	
	@Override
	public RazaStatus getRazaStatus(String its) throws FmbException {
		try {
			RazaStatus response = razaStatusRepository.getRazaStatus(its);
			return response == null ? new RazaStatus() : response;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FmbException("System Error");
		}
		
	}
	
	@Override
	public RazaStatus approveRazaStatus(String its) throws FmbException {
		try {
			RazaStatus razaStatus = getRazaStatus(its);
			if(razaStatus.getRequestDate() == null) { // This is equivalent to no rec found
				return razaStatus;
			}
			logger.info("Get before raza status"+razaStatus.toString());
			razaStatus.setApprovedDate(new Timestamp(new Date().getTime()));
			razaStatus.setRejectedDate(null);
			razaStatus.setRazaReceived(true);
			razaStatus.setRejectReason(null);
			razaStatusRepository.save(razaStatus);
			return razaStatus;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FmbException("Error in rejecting raza");
		}
	}

	@Override
	public RazaStatus rejectRazaStatus(String its, String reason) throws FmbException {
		try {
			RazaStatus razaStatus = getRazaStatus(its);
			if(razaStatus.getRequestDate() == null) { // This is equivalent to no rec found
				return razaStatus;
			}
			razaStatus.setRejectedDate(new Timestamp(new Date().getTime()));
			razaStatus.setApprovedDate(null);
			razaStatus.setRejectReason(reason);
			razaStatus.setRazaReceived(false);
			razaStatusRepository.save(razaStatus);
			return razaStatus;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FmbException("Error in rejecting raza");
		}
	}
}
