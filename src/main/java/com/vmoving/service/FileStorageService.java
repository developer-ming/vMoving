package com.vmoving.service;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	Path store(MultipartFile file);
}
