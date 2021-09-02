package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> getByIsActiveTrue(); // aktif iş ilanlarını getir
	List<JobAdvertisement> getByExpirationDateLessThanEqual(LocalDate date);
	List<JobAdvertisement> getByIsActiveTrueAndExpirationDateLessThanEqual(LocalDate date);
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> getByEmployerId(int id);
	List<JobAdvertisement> getByIsActiveTrueAndCity_Id(int id);
	List<JobAdvertisement> getByIsActiveTrueAndDepartment_Id(int id);
	List<JobAdvertisement> getById(int id);
}
