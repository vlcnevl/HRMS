package com.vlcnevl.HRMS.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByIsActiveTrue(); 
	DataResult<List<JobAdvertisement>> getByExpirationDateLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndExpirationDateLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCity_Id(int id);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndDepartment_Id(int id);
	DataResult<List<JobAdvertisement>> getById(int id);
	Result delete(int jobAdvertisementId);
	Result update(JobAdvertisement jobAdvertisement);

}
