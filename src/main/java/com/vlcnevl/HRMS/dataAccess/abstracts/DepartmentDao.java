package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
	List<Department> getByDepartmentName(String name);
}
