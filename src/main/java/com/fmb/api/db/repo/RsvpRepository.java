package com.fmb.api.db.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.Rsvp;

public interface RsvpRepository extends CrudRepository<Rsvp, Integer> {
	
	@Query("Select R from Rsvp R where R.user.id=?2 and R.menu.id in ?1")
	List<Rsvp> getByMenuIdsAndUserId(Set<Integer> menuIds, Integer userId);

}
