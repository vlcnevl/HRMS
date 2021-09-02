package com.vlcnevl.HRMS.business.abstracts;

import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
	Result delete(int cityId);
	Result update(City city);
}
