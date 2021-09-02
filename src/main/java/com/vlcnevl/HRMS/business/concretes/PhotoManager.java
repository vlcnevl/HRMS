package com.vlcnevl.HRMS.business.concretes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vlcnevl.HRMS.business.abstracts.CandidateService;
import com.vlcnevl.HRMS.business.abstracts.PhotoService;
import com.vlcnevl.HRMS.core.adapters.abstracts.CloudinaryService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.ErrorResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;
import com.vlcnevl.HRMS.dataAccess.abstracts.PhotoDao;
import com.vlcnevl.HRMS.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{
	
	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	private CandidateService candidateService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService, CandidateService candidateService) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll());
	}

	@Override
	public DataResult<List<Photo>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Photo>>(this.photoDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<Photo> getById(int id) {
		return new SuccessDataResult<Photo>(this.photoDao.getById(id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public Result add(MultipartFile multiparfile,int candidateId) throws IOException {
		var result = this.cloudinaryService.upload(multiparfile);
		
		if(!result.isSuccess())
		{
			return new ErrorResult(result.getMessage());
		}
		
		var candidate = candidateService.getById(candidateId).getData(); 
		Photo photo = new Photo();
		photo.setCandidate(candidate);
		photo.setImagePath(result.getData().get("url"));
		photo.setCloudinaryId(result.getData().get("public_id"));
		photo.setCreatedDate(LocalDate.now());
		
		this.photoDao.save(photo);
		return new SuccessResult("Photo added");
	}

	@Override
	public Result delete(int id) throws IOException {
		var cloudinaryId = this.photoDao.findById(id).get().getCloudinaryId();
		var result = cloudinaryService.delete(cloudinaryId);
		this.photoDao.deleteById(id);
		return new SuccessResult("Photo deleted");
	}


}
