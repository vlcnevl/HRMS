package com.vlcnevl.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findCandidateByEmailAndPassword(String email,String password);
	DataResult<Candidate> getByEmailOrNationalityId(String email,String nationalityId);
	Candidate getByNationalityId(String nationalityId);
	
}
