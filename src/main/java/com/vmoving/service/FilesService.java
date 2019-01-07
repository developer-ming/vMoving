package com.vmoving.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.vmoving.dto.ResultVO;

public interface FilesService {
	ResultVO save(String msg, CommonsMultipartFile faultImage);
}
