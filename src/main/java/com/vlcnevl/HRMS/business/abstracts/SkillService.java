package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
	DataResult<List<Skill>> getByCandidateId(int candidateId);
	Result delete(int skillId);
	Result update(Skill skill);
}
