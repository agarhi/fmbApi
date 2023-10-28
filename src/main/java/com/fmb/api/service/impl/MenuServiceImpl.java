package com.fmb.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.Menu;
import com.fmb.api.db.repo.MenuRepository;
import com.fmb.api.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public Iterable<Menu> getAll() {
		return menuRepository.findAll();
	}

}
