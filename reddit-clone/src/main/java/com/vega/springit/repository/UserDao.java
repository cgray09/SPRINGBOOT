package com.vega.springit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vega.springit.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User findByEmail(String email);
}