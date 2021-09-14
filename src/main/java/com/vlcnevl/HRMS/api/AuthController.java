package com.vlcnevl.HRMS.api;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.AuthService;
import com.vlcnevl.HRMS.core.utilities.results.ErrorResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.dtos.CandidateForRegisterDto;
import com.vlcnevl.HRMS.entities.dtos.EmployerForRegisterDto;
import com.vlcnevl.HRMS.entities.dtos.UserForLoginDto;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin
public class AuthController {

	private AuthService autService;
	
	@Autowired
	public AuthController(AuthService autService) {
		super();
		this.autService = autService;
	}
	
	@PostMapping("/employerregister")
	public Result employerRegister(@Valid @RequestBody EmployerForRegisterDto employerRegisterDto)
	{
		return this.autService.employerRegister(employerRegisterDto);
	}
	
	@PostMapping("/candidateregister")
	public Result candidateRegister(@Valid @RequestBody CandidateForRegisterDto candidateForRegisterDto)
	{
		return this.autService.candidateRegister(candidateForRegisterDto);
	}
	
	@PostMapping("/employerlogin")
	public Result employerLogin(@RequestBody UserForLoginDto user)
	{
		return this.autService.loginEmployer(user);
	}
	
	@PostMapping("/candidatelogin")
	public Result candidateLogin(@RequestBody UserForLoginDto user)
	{
		return this.autService.loginCandidate(user);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	public ErrorResult handleValidationException(MethodArgumentNotValidException exceptions)
	{	
		String validationErrors = null; 
		
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors())
		{
			validationErrors=fieldError.getDefaultMessage();
		}
		 
		return new ErrorResult(validationErrors);
	}
	

}
