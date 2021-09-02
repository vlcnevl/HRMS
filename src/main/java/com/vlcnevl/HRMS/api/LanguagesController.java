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

import com.vlcnevl.HRMS.business.abstracts.LanguageService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Language;

@RequestMapping("/api/languages")
@RestController
public class LanguagesController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Language>> getAll()
	{
		return this.languageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Language language)
	{
		return this.languageService.add(language);
	}
	
	@PostMapping("/getbycandidateid")
	public DataResult<List<Language>> getByCandidateId(int candidateId)
	{
		return this.languageService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int languageId)
	{
		return this.languageService.delete(languageId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Language language)
	{
		return this.languageService.update(language);
	}

}
