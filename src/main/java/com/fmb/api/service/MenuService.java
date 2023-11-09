package com.fmb.api.service;


import java.util.List;

import com.fmb.api.db.entity.Menu;

public interface MenuService {
	
	public List<Menu> getByWeek(int offset);

}
