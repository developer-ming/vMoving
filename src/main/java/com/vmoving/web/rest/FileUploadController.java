package com.vmoving.web.rest;

  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@PostMapping(path="/api/upload")
	public void upload(@RequestParam MultipartFile file) {
		
	}
	
	 
}
