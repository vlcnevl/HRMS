package com.vlcnevl.HRMS.api;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vlcnevl.HRMS.business.abstracts.PhotoService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.entities.concretes.Photo;

@RequestMapping("/api/photos")
@RestController
public class PhotosController {
	private PhotoService photoService;
	
	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Photo>> getAll()
	{
		return this.photoService.getAll();
	}
	
	@PostMapping("/getbycandidateid")
	public DataResult<List<Photo>> getByCandidateId(@RequestParam int candidateId)
	{
		return this.photoService.getByCandidateId(candidateId);
	}
	
	@PostMapping("/getbyid")
	public DataResult<Photo> getById(@RequestParam int id)
	{
		return this.photoService.getById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody MultipartFile multiparfile ,@RequestParam int candidateId) throws IOException
	{
		return ResponseEntity.ok(this.photoService.add(multiparfile, candidateId));
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) throws IOException
	{
		return this.photoService.delete(id);
	}

}
