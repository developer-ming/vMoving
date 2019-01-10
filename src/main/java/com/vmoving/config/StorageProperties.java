package com.vmoving.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("filestorage")
public class StorageProperties {
	private String uploadpath;

	public String getUploadpath() {
		return uploadpath;
	}

	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	
}
