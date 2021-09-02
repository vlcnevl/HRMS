package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.CoverLetter;

@Repository
public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
	List<CoverLetter> getByCandidateId(int candidateId);
}
