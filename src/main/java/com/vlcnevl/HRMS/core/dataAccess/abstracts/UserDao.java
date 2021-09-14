package com.vlcnevl.HRMS.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User getByEmail(String email);
	boolean existsByEmail(String email);
}
