package com.vlcnevl.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import org.modelmapper.ModelMapper;


import com.vlcnevl.HRMS.business.abstracts.AuthService;
import com.vlcnevl.HRMS.business.abstracts.CandidateService;
import com.vlcnevl.HRMS.business.abstracts.EmailService;
import com.vlcnevl.HRMS.business.abstracts.EmployeeService;
import com.vlcnevl.HRMS.business.abstracts.EmployerService;
import com.vlcnevl.HRMS.business.abstracts.UserService;
import com.vlcnevl.HRMS.core.adapters.abstracts.UserCheckService;
import com.vlcnevl.HRMS.core.utilities.business.BusinessRules;
import com.vlcnevl.HRMS.core.utilities.results.ErrorResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.entities.concretes.Candidate;
import com.vlcnevl.HRMS.entities.concretes.Employer;
import com.vlcnevl.HRMS.entities.dtos.CandidateForRegisterDto;
import com.vlcnevl.HRMS.entities.dtos.EmployerForRegisterDto;
import com.vlcnevl.HRMS.entities.dtos.UserForLoginDto;


@Service
public class AuthManager implements AuthService{
	
	private UserService userService;
	private UserCheckService userCheckService;
	private CandidateService candidateService;
	private EmployerService employerService;
	private EmployeeService employeeService;
	private EmailService emailService;
	private ModelMapper modelMapper;
	
	
	
	@Autowired
	public AuthManager(UserService userService, CandidateService candidateService, EmployerService employerService,
			EmployeeService employeeService,EmailService emailService,ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.employeeService = employeeService;
		this.emailService = emailService;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result employerRegister(EmployerForRegisterDto employerForRegisterDto) {
		
		var result = BusinessRules.run(
				checkEmailVertification(employerForRegisterDto.getEmail()),
				checkIfEmailExists(employerForRegisterDto.getEmail()),
				checkRePassword(employerForRegisterDto.getPassword(),employerForRegisterDto.getRePassword()));
		
		if(result!=null)
		{
			return result;
		}
		
		Employer registerEmployer = modelMapper.map(employerForRegisterDto,Employer.class);
		
		
		this.employerService.add(registerEmployer);
		return new SuccessResult("Registration successfully");
		
	}
	
	@Override
	public Result candidateRegister(CandidateForRegisterDto candidateFRegisterDto) {
		Result result = BusinessRules.run(
				checkEmailVertification(candidateFRegisterDto.getEmail()),
				checkIfEmailExists(candidateFRegisterDto.getEmail()),
				checkRePassword(candidateFRegisterDto.getPassword(),candidateFRegisterDto.getRePassword()));
				checkNationalityId(candidateFRegisterDto.getNationalityId());

				if(result!=null)
				{
					return result;
				}
				
				Candidate registerCandidate = modelMapper.map(candidateFRegisterDto, Candidate.class);
				registerCandidate.setStatus(false);
				
				this.candidateService.add(registerCandidate);
				return new SuccessResult("Registration successfully");
	}
	

	@Override
	public Result loginEmployer(UserForLoginDto userForLoginDto) {
		return this.employerService.login(userForLoginDto.getEmail(), userForLoginDto.getPassword());
	}

	@Override
	public Result loginCandidate(UserForLoginDto userForLoginDto) {
		return this.candidateService.login(userForLoginDto.getEmail(), userForLoginDto.getPassword());
	}




	
	//bussinessRules
	
	private Result checkIfEmailExists(String email)
	{
		if(!userService.existsByEmail(email))
		{
			return new SuccessResult();
		}
		return new ErrorResult("Email already exists");
	}
	
	private Result checkEmailVertification(String email)
	{
		Result result = this.emailService.vertification(email);
		if(result == null)
		{
			return new ErrorResult("Email couldnt verified ");
		}
		return new SuccessResult();
	}
	
	private Result checkRePassword(String password, String rePassword)
	{
		if(password.equals(rePassword))
		{
			return new SuccessResult();
		}
		
		return new ErrorResult("Passwords not same");
	}
	

	private Result checkNationalityId(String nationalityId) {
		
		Result result = this.candidateService.getByNationalityId(nationalityId);
		
		if (result.getMessage()!=null) {
			return new ErrorResult("User already registered.");
		}
		return new SuccessResult() ;
	}


}
