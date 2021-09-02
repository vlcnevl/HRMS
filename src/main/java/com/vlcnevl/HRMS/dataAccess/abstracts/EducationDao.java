package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.Education;

@Repository
public interface EducationDao extends JpaRepository<Education, Integer>{
	List<Education> getByCandidateId(Sort sort, int candidateId);
}
