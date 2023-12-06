package com.fmb.api.db.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.FoodFeedback;

public interface FoodFeedbackRepository extends CrudRepository<FoodFeedback, Integer> {

	@Query("select F from FoodFeedback F where F.menu.id in ?1 order by F.menu.id asc")
	List<FoodFeedback> getByMenuIds(Set<Integer> menuIds);
	
}