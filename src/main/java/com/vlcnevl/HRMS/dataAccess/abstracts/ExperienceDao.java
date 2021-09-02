package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlcnevl.HRMS.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
	List<Experience> getByCandidateId(int candidateId);
	
}
