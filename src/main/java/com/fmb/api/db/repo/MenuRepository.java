package com.fmb.api.db.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
	
	@Query("select M from Menu M where M.date between ?1 and ?2")
	List<Menu> getByWeek(Date startDate, Date endDate);
}
