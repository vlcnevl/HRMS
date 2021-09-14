package com.vlcnevl.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.EmailService;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result vertification(String email) {
		return new SuccessResult("Check to email");
	}

	
}
