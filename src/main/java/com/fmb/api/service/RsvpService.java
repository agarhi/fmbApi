package com.fmb.api.service;

import java.util.List;
import java.util.Set;

import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.response.RsvpResponse;

public interface RsvpService {
	
	public List<RsvpResponse> getByUserIdAndMenuOffset(int offset) throws FmbException;
	public List<RsvpResponse> updateRsvp(Set<Integer> menuIds, int offset, boolean choice) throws FmbException;
	public List<RsvpResponse> updateSize(Integer menuId, int offset, String size) throws FmbException;
	public List<RsvpResponse> updateCarbSelection(Integer menuId, int offset, boolean lessCarbsChoice) throws FmbException;
	
}
