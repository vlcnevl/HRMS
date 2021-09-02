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

import com.vlcnevl.HRMS.business.abstracts.EducationService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Education;

@RequestMapping("/api/educations")
@RestController
public class EducationsController {
	
	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll()
	{
		return this.educationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Education education)
	{
		return this.educationService.add(education);
	}
	
	@PostMapping("/getascorderbygraduationdate")
	public DataResult<List<Education>> getByCandidateIdOrderByGraduationDateASC(int candidateId)
	{
		return this.getByCandidateIdOrderByGraduationDateASC(candidateId);
	}
	
	@PostMapping("/getdescorderbygraduationdate")
	public DataResult<List<Education>> getByCandidateIdOrderByGraduationDateDESC(int candidateId)
	{
		return this.educationService.getByCandidateIdOrderByGraduationDateDESC(candidateId);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int educationId)
	{
		return this.educationService.delete(educationId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Education education)
	{
		return this.educationService.update(education);
	}
}
