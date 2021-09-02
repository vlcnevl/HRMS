package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {
	List<Language> getByCandidateId(int candidateId);
}
