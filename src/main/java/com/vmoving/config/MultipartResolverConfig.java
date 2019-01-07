package com.vmoving.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartResolverConfig {
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		multipartResolver.setMaxUploadSize(10485760);
		multipartResolver.setMaxInMemorySize(4096);
		multipartResolver.setDefaultEncoding("UTF-8");
		
		return multipartResolver;
	}

}
