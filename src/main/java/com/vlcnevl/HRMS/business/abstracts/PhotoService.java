package com.vlcnevl.HRMS.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Photo;

public interface PhotoService {
	DataResult<List<Photo>> getAll();
	DataResult<List<Photo>> getByCandidateId(int candidateId);
	DataResult<Photo> getById(int id);
	Result add(MultipartFile multiparfile ,int candidateId) throws IOException;
	Result delete(int id) throws IOException; 
}
