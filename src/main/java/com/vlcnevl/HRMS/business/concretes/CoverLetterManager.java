package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.CoverLetterService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.CoverLetterDao;
import com.vlcnevl.HRMS.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {
	
	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter added");
	}

	@Override
	public DataResult<List<CoverLetter>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.getByCandidateId(candidateId));
	}

	@Override
	public Result delete(int coverLetterId) {
		this.coverLetterDao.deleteById(coverLetterId);
		return new SuccessResult("Cover letter deleted");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		CoverLetter updateCoverLetter = this.coverLetterDao.getById(coverLetter.getId());
		updateCoverLetter.setWriting(coverLetter.getWriting());
		this.coverLetterDao.save(updateCoverLetter);
		return new SuccessResult("Cover letter updated");
	}

}
