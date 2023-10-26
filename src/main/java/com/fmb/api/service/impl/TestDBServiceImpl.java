package com.fmb.api.service.impl;

import com.fmb.api.service.TestDBService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

@Service
public class TestDBServiceImpl implements TestDBService {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public String getDate() {
		String jpql = "SELECT SYSDATE()";
        Query query = entityManager.createNativeQuery(jpql);
         
        return query.getSingleResult().toString();
	}

}
