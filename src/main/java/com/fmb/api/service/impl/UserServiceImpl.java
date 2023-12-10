package com.fmb.api.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fmb.api.db.entity.User;
import com.fmb.api.db.repo.UserRepository;
import com.fmb.api.db.repo.UserRepository.PendingUserRaza;
import com.fmb.api.error.handling.FmbException;
import com.fmb.api.model.request.SignUpRequest;
import com.fmb.api.service.RazaStatusService;
import com.fmb.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private RazaStatusService razaStatusService;
	
	@Override
	public void register(SignUpRequest signUpRequest) throws FmbException {
		try {
			logger.info(signUpRequest.toString());
			User user = User.from(signUpRequest);
			user.getCredentials().setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
			user.setThalinum(getThaliNum());
			logger.info(user.toString());
			userRepository.save(user);
		} catch (DataIntegrityViolationException dive) {
			logger.error(dive.getMessage());
			throw new FmbException("Non unique values");
		} 
		catch(Exception e) {
			logger.error("Name "+e.getClass().getName());
			throw new FmbException("System error");
		}
	}

	@Override
	public User getByUsername(String username) throws FmbException {
		try {
			User user = userRepository.getByUsername(username);
			boolean razaRecd = razaStatusService.getRazaStatus(user.getIts()).isRazaReceived();
			if(!razaRecd) {
				throw new FmbException("Raza not received");
			}
			session().setAttribute("CURRENT_USER", user);
			return user;
		} catch (Exception e) {
			throw new FmbException(e.getMessage());
		}
	}
	
	private int getThaliNum() {
		String jpql = "SELECT nextval('ThaliNum')";
        Query query = entityManager.createNativeQuery(jpql);
        return Integer.parseInt(query.getSingleResult().toString());
	}
	
	private HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

	@Override
	public List<PendingUserRaza> getPendingRaza() throws FmbException {
		return userRepository.getPendingRaza();
	}
	
}
