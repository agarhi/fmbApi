package com.fmb.api.db.repo;

import org.springframework.data.repository.CrudRepository;

import com.fmb.api.db.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {}
