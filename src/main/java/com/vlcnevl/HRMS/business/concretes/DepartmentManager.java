package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.DepartmentService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.DepartmentDao;
import com.vlcnevl.HRMS.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService{
	
	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll());
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Department added");
	}

	@Override
	public DataResult<List<Department>> getByDepartmentName(String name) {
		return new SuccessDataResult<List<Department>>(this.departmentDao.getByDepartmentName(name));
	}

	@Override
	public Result delete(int departmentId) {
		this.departmentDao.deleteById(departmentId);
		return new SuccessResult("Department deleted");
	}

	@Override
	public Result update(Department department) {
		
		Department updateDepartment = this.departmentDao.getById(department.getId());
		updateDepartment.setDepartmentName(department.getDepartmentName());
		updateDepartment.setDescription(department.getDescription());
		this.departmentDao.save(updateDepartment);
		return new SuccessResult("Department updated");
	}

}
