package com.fmb.api.db.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.Rsvp;

public interface RsvpRepository extends CrudRepository<Rsvp, Integer> {
	
	@Query("Select R from Rsvp R where R.user.id=?2 and R.menu.id in ?1")
	List<Rsvp> getByMenuIdsAndUserId(Set<Integer> menuIds, Integer userId);
	
	@Modifying
	@Query("Update Rsvp R set R.rsvp=?3 where R.user.id=?1 and R.menu.id in ?2")
	void updateRsvp(Integer userId, Set<Integer> menuIds, boolean choice);

}
