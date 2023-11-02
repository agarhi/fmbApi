package com.fmb.api.service;

import com.fmb.api.db.entity.RazaStatus;
import com.fmb.api.error.handling.FmbException;

public interface RazaStatusService {
	public RazaStatus getRazaStatus(String its) throws FmbException;

	public RazaStatus approveRazaStatus(String its) throws FmbException;
	
	public RazaStatus rejectRazaStatus(String its, String reason) throws FmbException;
}
