package com.vlcnevl.HRMS.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vlcnevl.HRMS.core.adapters.abstracts.CloudinaryService;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.ErrorDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;

@Component
public class CloudinaryManager implements CloudinaryService{
	
	private Cloudinary cloudinary;
	
	public CloudinaryManager() {
		
	/*	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dx7wc9sqh",
				"api_key", "372562346743541",
				"api_secret", "vKOSyjUvDG2uD79MAMYNADyN84c",
				"secure", true)); */
		
		Map<String , String> valuesMap = new HashMap<String, String>();
		valuesMap.put("cloud_name", "dx7wc9sqh");
		valuesMap.put("api_key", "372562346743541");
		valuesMap.put("api_secret", "vKOSyjUvDG2uD79MAMYNADyN84c");
		cloudinary = new Cloudinary(valuesMap);
		
	}

	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try
		{
			file = convert(multipartFile);
			Map<String,String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<>(result);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			return new ErrorDataResult<>("File not upload");
		}
		
		
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return new SuccessDataResult<>(result);
	}
	
	private File convert (MultipartFile multiparFile) throws IOException
	{
		File file = new File (multiparFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multiparFile.getBytes());
		stream.close();
		return file;
	}
	
	
}
