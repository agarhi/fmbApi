package com.fmb.api.service.impl;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmb.api.db.entity.Menu;
import com.fmb.api.db.repo.MenuRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<Menu> getByWeek(long offset) throws FmbException {
		// offset 0 means current week
		
		long todayInMillis = new java.util.Date().getTime();
		long startDateInMillis = todayInMillis + (offset * 7 * 24 * 60 * 60 * 1000);
		
		return getByWeekRange(startDateInMillis);
		
	}

	@Override
	public List<Menu> getByDate(String date) throws FmbException {
		
		try {
			List<Menu> menus = null;
					
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd");
			
			long startDateInMillis = simpleDateFormat.parse(date).getTime();
			menus = getByWeekRange(startDateInMillis);
			
			if(menus == null || menus.size() == 0) {
				menus = new ArrayList<Menu>();
				for(int i = 0; i < 7; i++) {
					Date dateSql = new Date((i * 24 * 60 * 60 * 1000) + getStartOfWeek(startDateInMillis));
					Menu menu = Menu.from(dateSql, "TBD", false);
					menus.add(menu);
				}
			}
			return menus;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new FmbException(e.getMessage());
		}
		
	}
	
	private List<Menu> getByWeekRange(long dateInMills) {
		
		long mondayInMillis = getStartOfWeek(dateInMills);
		
		long nextSundayInMillis = mondayInMillis + (6 * 24 * 60 * 60 * 1000); // we use 6 here because later we use between and MySQL between is inclusive of both dates
		
		Date startDate = new Date(mondayInMillis);
		logger.info("startDate "+startDate.toString());
		
		Date endDate = new Date(nextSundayInMillis);
		logger.info("endDate "+endDate.toString());
		
		return menuRepository.getByWeek(startDate, endDate);
		
	}
	
	private long getStartOfWeek(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTimeInMillis(date);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		long mondayInMillis = calendar.getTime().getTime();
		
		return mondayInMillis;
	}

}
