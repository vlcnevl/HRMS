package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Language;


public interface LanguageService {
	DataResult<List<Language>> getAll();
	Result add(Language language);
	DataResult<List<Language>> getByCandidateId(int candidateId);
	Result delete(int languageId);
	Result update(Language language);
}
