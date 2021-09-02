package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Department;

public interface DepartmentService {
	DataResult<List<Department>> getAll();
	Result add(Department department);
	DataResult<List<Department>> getByDepartmentName(String name);
	Result delete(int departmentId);
	Result update(Department department);
}
