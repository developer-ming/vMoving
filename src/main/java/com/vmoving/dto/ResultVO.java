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
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
