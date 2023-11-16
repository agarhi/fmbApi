package com.fmb.api.service;


import java.util.List;

import com.fmb.api.db.entity.Menu;
import com.fmb.api.error.handling.FmbException;

public interface MenuService {
	
	public List<Menu> getByWeek(long offset) throws FmbException;
	
	public List<Menu> getByDate(String date) throws FmbException;

}
