package com.vlcnevl.HRMS.business.abstracts;

import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.dtos.CandidateForRegisterDto;
import com.vlcnevl.HRMS.entities.dtos.EmployerForRegisterDto;
import com.vlcnevl.HRMS.entities.dtos.UserForLoginDto;

public interface AuthService {
	Result employerRegister(EmployerForRegisterDto employerForRegisterDto);
	Result candidateRegister(CandidateForRegisterDto candidateFRegisterDto);
	Result loginEmployer(UserForLoginDto userForLoginDto);
	Result loginCandidate(UserForLoginDto userForLoginDto);


}
