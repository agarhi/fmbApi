package com.fmb.api.db.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.SpecialInstructions;

public interface SpInstructionsRepository extends CrudRepository<SpecialInstructions, Integer> {
	@Query("SELECT S FROM SpecialInstructions S where S.date=?1")
	SpecialInstructions getByDate(Date date); 
}
