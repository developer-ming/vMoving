package com.vmoving;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VMoving {

	private static final Logger log = LoggerFactory.getLogger(VMoving.class);
	public static void main(String[] args) {
		 SpringApplication.run(VMoving.class, args);
	    log.warn("vMoving end.....");
	}
}