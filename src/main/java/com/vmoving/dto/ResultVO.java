package com.vmoving.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultVO<T> implements Serializable {
 

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 379330280421837373L;
	private Integer code;
	private String msg;
	private T data;

}
