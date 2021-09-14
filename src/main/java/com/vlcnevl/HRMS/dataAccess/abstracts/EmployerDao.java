package com.vlcnevl.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer findEmployerByEmailAndPassword(String email,String password);
}
