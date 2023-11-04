package com.fmb.api.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.fmb.api.db.entity.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, Integer> {

	UserDetails findByUsername(String username);
	
}