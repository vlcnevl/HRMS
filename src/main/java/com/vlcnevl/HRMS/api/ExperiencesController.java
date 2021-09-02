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

import com.vlcnevl.HRMS.business.abstracts.ExperienceService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Experience;

@RequestMapping("/api/experiences")
@RestController
public class ExperiencesController {
	
	private ExperienceService experienceService;
	
	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll()
	{
		return this.experienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experience experience)
	{
		return this.experienceService.add(experience);
	}
	
	@PostMapping("/getbycandidateid")
	public DataResult<List<Experience>> getByCandidateId(int candidateId)
	{
		return this.experienceService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/delete")
	public Result add(@Valid @RequestParam int experienceId)
	{
		return this.experienceService.delete(experienceId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Experience experience)
	{
		return this.experienceService.update(experience);
	}
	
}
