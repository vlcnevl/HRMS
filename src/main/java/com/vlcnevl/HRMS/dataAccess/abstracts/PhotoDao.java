package com.vlcnevl.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlcnevl.HRMS.entities.concretes.Photo;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Integer>{
	List<Photo> getByCandidateId(int candidateId);
	Photo getById(int id);
}
