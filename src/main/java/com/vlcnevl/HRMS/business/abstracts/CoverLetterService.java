package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.CoverLetter;


public interface CoverLetterService {
	
	DataResult<List<CoverLetter>> getAll();
	Result add(CoverLetter coverLetter);
	DataResult<List<CoverLetter>> getByCandidateId(int candidateId);
	Result delete(int coverLetterId);
	Result update(CoverLetter coverLetter);
}
