package com.vlcnevl.HRMS.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlcnevl.HRMS.business.abstracts.CityService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.City;

@RequestMapping("/api/cities")
@RestController
public class CitiesController {
	
	private CityService cityService;
		
	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody City city)
	{
		return this.cityService.add(city);
	}
	
	@PostMapping("/delete")
	public Result delete(int cityId)
	{
		return this.cityService.delete(cityId);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody City city)
	{
		return this.cityService.update(city);
	}

	
}
