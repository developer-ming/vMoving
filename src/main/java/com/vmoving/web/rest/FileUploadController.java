package com.vmoving.web.rest;

  
import java.nio.file.Path;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.vmoving.service.FileStorageService;

@RestController
public class FileUploadController {
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@PostMapping(path="/api/upload")
	public HashMap<String, String> upload(@RequestParam MultipartFile file) {
		try {
			logger.warn(file.getOriginalFilename());
			Path path = fileStorageService.store(file);
			HashMap<String, String> map=new HashMap<String,String>();
			
			if(!path.toString().isEmpty()) {
				String[] pathArrayStrings = path.toString().split("uploadimages");
				String imgValue = pathArrayStrings[1];
				map.put("imagepath", imgValue);
			}
			map.put("Status", "Ok");
			
			return map;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			HashMap<String, String> map=new HashMap<String,String>();
			map.put("Status", "Failed");
			return map;
		}
	}
	
	 
}
