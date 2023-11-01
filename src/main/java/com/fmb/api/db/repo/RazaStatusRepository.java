package com.fmb.api.db.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.RazaStatus;

public interface RazaStatusRepository extends CrudRepository<RazaStatus, Integer> {
	@Query("SELECT R FROM User U inner join RazaStatus R ON U.its=?1")
	RazaStatus getRazaStatus(String its); 
}
