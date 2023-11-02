package com.fmb.api.db.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.RazaStatus;

public interface RazaStatusRepository extends CrudRepository<RazaStatus, Integer> {
	@Query("SELECT R FROM RazaStatus R, User U where U.its=?1 and U.razaStatus = R.id")
	RazaStatus getRazaStatus(String its); 
}
