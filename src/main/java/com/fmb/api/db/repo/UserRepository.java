package com.fmb.api.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT U FROM User U, Credentials C WHERE C.username = ?1 AND U.credentials = C.id")
	User getByUsername(String username);
	
	@Query("SELECT U.fname as fname, U.lname as lname, U.its as its, U.createdDate as createdDate "
			+ "FROM User U WHERE U.razaStatus.razaReceived = 0 order by U.createdDate")
	List<PendingUserRaza> getPendingRaza();
	
	 public static interface PendingUserRaza {
		String getFname();
		String getLname();
		String getIts();
		String getCreatedDate();
	}
	
}
