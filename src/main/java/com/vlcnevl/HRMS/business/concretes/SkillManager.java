package com.vlcnevl.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.SkillService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.SkillDao;
import com.vlcnevl.HRMS.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessResult("Skill added");
	}

	@Override
	public DataResult<List<Skill>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Skill>>(this.skillDao.getByCandidateId(candidateId));
	}

	@Override
	public Result delete(int skillId) {
		this.skillDao.deleteById(skillId);
		return new SuccessResult("Skill deleted");
	}

	@Override
	public Result update(Skill skill) {
		
		Skill updateSkill = this.skillDao.getById(skill.getId());
		updateSkill.setSkillLevel(skill.getSkillLevel());
		updateSkill.setSkillName(skill.getSkillName());
		this.skillDao.save(updateSkill); 
		return new SuccessResult("Skill updated");
	}

}
