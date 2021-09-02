package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlcnevl.HRMS.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	City getByName(String name);
}
