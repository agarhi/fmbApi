package com.fmb.api.db.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT U FROM User U, Credentials C WHERE C.username = ?1 AND U.credentials = C.id")
	User getByUsername(String username);
	
}
