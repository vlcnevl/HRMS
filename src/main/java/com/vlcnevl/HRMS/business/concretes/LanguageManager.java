package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.LanguageService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.LanguageDao;
import com.vlcnevl.HRMS.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
		
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Language added");
	}

	@Override
	public DataResult<List<Language>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Language>>(this.languageDao.getByCandidateId(candidateId));
	}

	@Override
	public Result delete(int languageId) {
		this.languageDao.deleteById(languageId);
		return new SuccessResult("Language deleted");
	}

	@Override
	public Result update(Language language) {
		
		Language updateLanguage = this.languageDao.getById(language.getId());
		updateLanguage.setLevel(language.getLevel());
		updateLanguage.setName(language.getName());
		this.languageDao.save(updateLanguage);
		return new SuccessResult("Language updated");
	}
	
	
}
