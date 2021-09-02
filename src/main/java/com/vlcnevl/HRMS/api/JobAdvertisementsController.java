package com.vlcnevl.HRMS.api;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.JobAdvertisementService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.JobAdvertisement;

@RequestMapping("/api/jobadvertisement")
@RestController
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll()
	{
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@Valid @RequestBody JobAdvertisement jobAdvertisement) //
	{
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() 
	{
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@PostMapping("/getByApplicationDeadlineLessThanEqual")
	public DataResult<List<JobAdvertisement>> getByExpirationDateLessThanEqual(@RequestParam @DateTimeFormat(iso =DateTimeFormat.ISO.DATE ) LocalDate date)
	{
		return this.jobAdvertisementService.getByExpirationDateLessThanEqual(date);
	}
	
	@PostMapping("/getByIsActiveTrueAndApplicationDeadlineLessThanEqual")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndExpirationDateLessThanEqual(@RequestParam  @DateTimeFormat(iso =DateTimeFormat.ISO.DATE ) LocalDate date)
	{
		return this.jobAdvertisementService.getByIsActiveTrueAndExpirationDateLessThanEqual(date);
	}
	
	@PostMapping("/getByIsActiveTrueAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(@RequestParam String companyName)
	{
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
	}
	
	@PostMapping("/getByEmployerUserId")
	public DataResult<List<JobAdvertisement>> getByEmployerId(@RequestParam int id)
	{
		return this.jobAdvertisementService.getByEmployerId(id);
	}
	
	@PostMapping("/getByIsActiveTrueAndCity_Id")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCity_Id(@RequestParam int id)
	{
		return this.jobAdvertisementService.getByIsActiveTrueAndCity_Id(id);
	}
	@PostMapping("/getByIsActiveTrueAndDepartment_Id")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndDepartment_Id(@RequestParam int id)
	{
		return this.jobAdvertisementService.getByIsActiveTrueAndDepartment_Id(id);
	}
	@PostMapping("/getbyid")
	public DataResult<List<JobAdvertisement>> getById(@RequestParam int  id)
	{
		return this.jobAdvertisementService.getById(id);
	}
	
	@PostMapping("/delete")
	Result delete(@RequestBody int jobAdvertisementId) 
	{
		return this.jobAdvertisementService.delete(jobAdvertisementId);
	}
	@PostMapping("/update")
	Result update(@Valid @RequestBody JobAdvertisement jobAdvertisement) //
	{
		return this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	
}
