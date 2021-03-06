package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Candidate;
import com.vlcnevl.HRMS.entities.dtos.CvDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	DataResult<Candidate> getById(int candidateId);
	DataResult<Candidate> getByNationalityId(String nationalityId);
	DataResult<CvDto> getCvById(int id);
	Result login(String email,String password);
	DataResult<Candidate> getByEmailOrNationalityId(String email,String nationalityId);
}
