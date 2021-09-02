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

import com.vlcnevl.HRMS.business.abstracts.CoverLetterService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.CoverLetter;

@RequestMapping("/api/coverletters")
@RestController
public class CoverLettersController {
	
	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll()
	{
		return coverLetterService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CoverLetter coverLetter)
	{
		return this.coverLetterService.add(coverLetter);
	}
	
	@PostMapping("/getbycandidateid")
	public DataResult<List<CoverLetter>> getByCandidateId(@RequestParam int candidateId)
	{
		return this.coverLetterService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int coverLetterId)
	{
		return this.coverLetterService.delete(coverLetterId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody CoverLetter coverLetter)
	{
		return this.coverLetterService.update(coverLetter);
	}
	
	
	
}
