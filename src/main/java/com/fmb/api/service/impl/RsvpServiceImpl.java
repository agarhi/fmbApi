package com.fmb.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fmb.api.db.entity.Menu;
import com.fmb.api.db.entity.Rsvp;
import com.fmb.api.db.entity.User;
import com.fmb.api.db.repo.MenuRepository;
import com.fmb.api.db.repo.RsvpRepository;
import com.fmb.api.db.repo.UserRepository;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.MenuRsvp;
import com.fmb.api.model.response.RsvpResponse;
import com.fmb.api.service.MenuService;
import com.fmb.api.service.RsvpService;

@Service
public class RsvpServiceImpl implements RsvpService {
	
	private static final Logger logger = LoggerFactory.getLogger(RsvpServiceImpl.class);
	
	@Autowired
	private RsvpRepository rsvpRepository;
	
	@Autowired
	private MenuService menuService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<RsvpResponse> getByUserIdAndMenuOffset(int offset) throws FmbException {
		// offset 0 means current week
		
		int useridSession = ((User)session().getAttribute("CURRENT_USER")).getId();
		
		List<Menu> menuList =  menuService.getByWeek(offset);
		logger.info("menuList "+menuList.toString());
		
		Set<Integer> menuIds = new HashSet<>();
		for(Menu m : menuList) {
			menuIds.add(m.getId());
		}
		
		logger.info("menuIds "+menuIds.toString());
		logger.info("userid "+useridSession);
		
		List<Rsvp> rsvpList = rsvpRepository.getByMenuIdsAndUserId(menuIds, useridSession);
		logger.info("rsvpList "+rsvpList);
		
		Map<Integer, Rsvp> rsvpMap = new HashMap<>();
		
		for(Rsvp r : rsvpList) {
			rsvpMap.put(r.getMenu().getId(), r);
		}
		
		List<RsvpResponse> response = new ArrayList<>();
		for(Menu m : menuList) {
			MenuRsvp menuRsvp = new MenuRsvp();
			menuRsvp.setMenu(m);
			RsvpResponse menuRsvpDate = new RsvpResponse();
			Rsvp rsvp = rsvpMap.get(m.getId());
			if(rsvp != null) {
				menuRsvp.setSize(rsvp.getSize());
				menuRsvp.setLessCarbs(rsvp.isLessCarbs());
				menuRsvp.setAdultCount(rsvp.getAdultCount());
				menuRsvp.setKidCount(rsvp.getKidsCount());
				menuRsvpDate.setRsvp(rsvp.isRsvp());
			} else {
				menuRsvpDate.setRsvp(false);
			}
			menuRsvpDate.setDate(m.getDate());
			menuRsvpDate.setMenuRsvp(menuRsvp);
			response.add(menuRsvpDate);
		}
		
		return response;
		
	}

	@Override
	@Transactional
	public List<RsvpResponse> updateRsvp(Set<Integer> menuIds, int offset, boolean choice) throws FmbException {
		Integer userId = userId();
		List<Rsvp> rsvpList = new ArrayList<>();
		for(Integer menuid : menuIds) {
			Rsvp rsvp = rsvpRepository.getByMenuIdAndUserId(menuid, userId);
			if(rsvp == null) {
				User user = userRepository.findById(userId).get();
				Menu menu = menuRepository.findById(menuid).get();
				rsvp = Rsvp.from(user, menu, user.getPreference(), choice);
				rsvpList.add(rsvp);
			} else {
				rsvp.setRsvp(choice); 
			}
			
		}
		rsvpRepository.saveAll(rsvpList);
		return getByUserIdAndMenuOffset(offset);
	}

	@Override
	public List<RsvpResponse> updateSize(Integer menuId, int offset, String size) throws FmbException {
		Rsvp rsvp = rsvpRepository.getByMenuIdAndUserId(menuId, userId());
		rsvp.setSize(size); 
		rsvpRepository.save(rsvp);
		return getByUserIdAndMenuOffset(offset);
	}

	@Override
	public List<RsvpResponse> updateCarbSelection(Integer menuId, int offset, boolean lessCarbsChoice)
			throws FmbException {
		Rsvp rsvp = rsvpRepository.getByMenuIdAndUserId(menuId, userId());
		logger.info("updateCarbs Rsvp loaded "+rsvp);
		rsvp.setLessCarbs(lessCarbsChoice); 
		rsvpRepository.save(rsvp);
		return getByUserIdAndMenuOffset(offset);
	}
	
	private HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
	
	private int userId() {
		int userId = ((User)session().getAttribute("CURRENT_USER")).getId();;
		logger.info("User id from session is "+userId);
		return userId;
	}
}
