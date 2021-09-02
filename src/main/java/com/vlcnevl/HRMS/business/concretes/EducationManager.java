package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.EducationService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.EducationDao;
import com.vlcnevl.HRMS.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
	
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Education added");
	}

	@Override
	public DataResult<List<Education>> getByCandidateIdOrderByGraduationDateASC(int candidateId) {
		Sort sortBy = Sort.by(Sort.Direction.ASC,"graduationDate");
		return new SuccessDataResult<List<Education>>(this.educationDao.getByCandidateId(sortBy, candidateId));
	}

	@Override
	public DataResult<List<Education>> getByCandidateIdOrderByGraduationDateDESC(int candidateId) {
		Sort sortBy = Sort.by(Sort.Direction.DESC,"graduationDate"); 
		
		return new SuccessDataResult<List<Education>>(this.educationDao.getByCandidateId(sortBy, candidateId));
	}

	@Override
	public Result delete(int educationId) {
		this.educationDao.deleteById(educationId);
		return new SuccessResult("Education deleted");
	}

	@Override
	public Result update(Education education) {
		
		Education updateEducation = this.educationDao.getById(education.getId());
		updateEducation.setGraduationDate(education.getGraduationDate());
		updateEducation.setProgramName(education.getProgramName());
		updateEducation.setSchoolName(education.getProgramName());
		updateEducation.setStartDate(education.getGraduationDate());
		this.educationDao.save(updateEducation);
		return new SuccessResult("Education updated");
	}



}
