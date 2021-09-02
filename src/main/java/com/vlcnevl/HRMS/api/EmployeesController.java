package com.vlcnevl.HRMS.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.EmployeeService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.ErrorDataResult;
import com.vlcnevl.HRMS.entities.concretes.Employee;

@RequestMapping("/api/employees")
@RestController
public class EmployeesController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll()
	{
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee)
	{
		return ResponseEntity.ok(this.employeeService.add(employee)); 
	}
	
	// other class 
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions)
	{	
		Map<String,String> validationErrors = new HashMap<String,String>(); 
		
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors())
		{
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}
