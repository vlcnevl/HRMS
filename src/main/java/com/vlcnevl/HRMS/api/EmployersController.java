package com.vlcnevl.HRMS.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.EmployerService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.ErrorDataResult;

import com.vlcnevl.HRMS.entities.concretes.Employer;


@RequestMapping("/api/employers")
@RestController
public class EmployersController {
	
	private EmployerService employerService;

	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll()
	{
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer)
	{
		return ResponseEntity.ok(this.employerService.add(employer)); 
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions)
	{	
		Map<String,String> validationErrors = new HashMap<String,String>(); 
		
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors())
		{
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Do??rulama hatalar??");
		return errors;
	}
	
}
