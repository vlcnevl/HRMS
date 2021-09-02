package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Integer>{
	List<Skill> getByCandidateId(int candidateId);
}
