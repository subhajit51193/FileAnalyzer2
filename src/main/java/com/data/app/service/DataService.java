package com.data.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.data.app.entity.Data;

public interface DataService {

	public String save(MultipartFile file) throws IOException;
	
	public List<Data> getAllData();
}
