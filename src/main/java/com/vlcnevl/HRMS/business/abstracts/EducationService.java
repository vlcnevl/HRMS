package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;

import com.vlcnevl.HRMS.entities.concretes.Education;

public interface EducationService {
	DataResult<List<Education>> getAll();
	Result add(Education education);
	DataResult<List<Education>> getByCandidateIdOrderByGraduationDateASC(int candidateId);
	DataResult<List<Education>> getByCandidateIdOrderByGraduationDateDESC(int candidateId);
	Result delete(int educationId);
	Result update(Education education);
}
