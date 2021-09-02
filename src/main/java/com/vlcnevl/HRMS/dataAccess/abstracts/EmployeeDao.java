package com.vlcnevl.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
