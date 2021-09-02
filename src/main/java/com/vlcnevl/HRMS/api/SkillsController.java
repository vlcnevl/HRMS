package com.vlcnevl.HRMS.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.SkillService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Skill;

@RequestMapping("/api/skills")
@RestController
public class SkillsController {
	
	private SkillService skillService;
	
	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Skill>> getAll()
	{
		return this.skillService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@Valid @RequestBody Skill skill)
	{
		return this.skillService.add(skill);
	}
	
	@PostMapping("/getbycandidateid")
	public DataResult<List<Skill>> getByCandidateId(int candidateId)
	{
		return this.getByCandidateId(candidateId);
	}
	
	@PostMapping("/delete")
	Result delete(@RequestParam int skillId)
	{
		return this.skillService.delete(skillId);
	}
	
	@PostMapping("/update")
	Result update(@Valid @RequestBody Skill skill)
	{
		return this.skillService.update(skill);
	}
	
	
	
}
