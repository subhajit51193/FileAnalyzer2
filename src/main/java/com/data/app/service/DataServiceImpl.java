package com.data.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.data.app.entity.Data;
import com.data.app.helper.Helper;
import com.data.app.repository.DataRepository;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	private Helper helper;
	
	@Autowired
	private DataRepository dataRepository;
	
	/*
	 * Saves the data from Excel into Database
	 * 
	 * @param: MultipartFile -> Excel file
	 * 
	 * @return: String -> Customized message upon success
	 */
	@Override
	public String save(MultipartFile file) throws IOException {
		
		List<Data> list = helper.convertExcelToListOfProduct(file.getInputStream());
		for (Data data: list) {
			dataRepository.save(data);
		}
		return "saved ";
	}

	@Override
	public List<Data> getAllData() {
		
		return dataRepository.findAll();
	}

}
