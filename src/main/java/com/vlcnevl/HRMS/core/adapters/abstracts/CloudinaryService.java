package com.vlcnevl.HRMS.core.adapters.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.vlcnevl.HRMS.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<Map<String , String>> upload(MultipartFile multipartFile);
	DataResult<Map> delete(String id) throws IOException;
}
