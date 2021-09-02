package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.ExperienceService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.ExperienceDao;
import com.vlcnevl.HRMS.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience added");
	}

	@Override
	public DataResult<List<Experience>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByCandidateId(candidateId));
	}

	@Override
	public Result delete(int experienceId) {
		this.experienceDao.deleteById(experienceId);
		return new SuccessResult("Experience deleted");
	}

	@Override
	public Result update(Experience experience) {
		Experience updateExperience = this.experienceDao.getById(experience.getId());
		updateExperience.setDepartureDate(experience.getDepartureDate());
		updateExperience.setPosition(experience.getPosition());
		updateExperience.setStartDate(experience.getStartDate());
		updateExperience.setWorkplaceName(experience.getWorkplaceName());
		this.experienceDao.save(updateExperience);
		return new SuccessResult("Education updated");
	}

}
