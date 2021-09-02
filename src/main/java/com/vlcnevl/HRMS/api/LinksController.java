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

import com.vlcnevl.HRMS.business.abstracts.LinkService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Link;

@RequestMapping("/api/links")
@RestController
public class LinksController {
	private LinkService linkService;
	
	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Link>> getAll()
	{
		return this.linkService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Link link)
	{
		return this.linkService.add(link);
	}
	
	@PostMapping("/getbycandidateid")
	public DataResult<List<Link>> getById(@RequestParam int candidateId)
	{
		return this.linkService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int linkId)
	{
		return this.linkService.delete(linkId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Link link)
	{
		return this.linkService.update(link);
	}
}
