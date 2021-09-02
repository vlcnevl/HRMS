package com.vlcnevl.HRMS.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.DepartmentService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Department;

@RequestMapping("/api/departments")
@RestController
public class DepartmentsController {
	
	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentsController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	 
	@GetMapping("/getall")
	public DataResult<List<Department>> getAll()
	{
		return this.departmentService.getAll();
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Department department)
	{
		return this.departmentService.add(department);
	}
	
	@PostMapping("/getbydepartmentname")
	public Result getByDepartmentName(@RequestParam String name)
	{
		return this.departmentService.getByDepartmentName(name);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int departmentId)
	{
		return this.departmentService.delete(departmentId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Department department)
	{
		return this.departmentService.update(department);
	}
	
}
