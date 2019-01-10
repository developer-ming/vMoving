package com.vmoving.service.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.nio.file.Files;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vmoving.config.StorageProperties;
import com.vmoving.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {
	private static final Logger log = LoggerFactory.getLogger(FileStorageServiceImpl.class);
	private final Path rootLocation;

	@Autowired
	public FileStorageServiceImpl(StorageProperties properties, ServletContext context) {
		this.rootLocation = Paths.get(context.getRealPath("/") + "/" + properties.getUploadpath());
	}

	@Override
	public Path store(MultipartFile file) {
		Path filePath = null;
		try {
			if (file.isEmpty()) {
				log.error("Failed to store empty file " + file.getOriginalFilename());
				throw new IOException("Failed to store empty file " + file.getOriginalFilename());
			}
			if (Files.notExists(this.rootLocation)) {
				Files.createDirectory(this.rootLocation);
			}

			filePath = this.rootLocation.resolve(UUID.randomUUID().toString());
			if (Files.notExists(filePath)) {
				Files.createDirectory(filePath);
			}
			filePath = filePath.resolve(file.getOriginalFilename());
			Files.copy(file.getInputStream(), filePath);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return filePath;
	}
}
