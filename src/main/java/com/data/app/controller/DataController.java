package com.data.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.data.app.entity.Data;
import com.data.app.service.DataService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins =  "*")
public class DataController {

	@Autowired
	private DataService dataService;
	
	@PostMapping("/file/upload")
	public ResponseEntity<String> saveFileDetails(@RequestParam("file") MultipartFile file) throws IOException{
		
		String res = dataService.save(file);
		return new ResponseEntity<String>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allData")
	public ResponseEntity<List<Data>> getAllData(){
		
		List<Data> list = dataService.getAllData();
		return new ResponseEntity<List<Data>>(list,HttpStatus.OK);
	}
}
