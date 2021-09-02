package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Experience;

public interface ExperienceService {
	DataResult<List<Experience>> getAll();
	Result add(Experience experience);
	DataResult<List<Experience>> getByCandidateId(int candidateId);
	Result delete(int experienceId);
	Result update(Experience experience);
	
}
