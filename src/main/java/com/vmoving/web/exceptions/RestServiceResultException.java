package com.vmoving.web.exceptions;

public class RestServiceResultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1744593740116981156L;
 
	private int errorCode;
	private String errorMsg;
	
	public RestServiceResultException(int code,String msg) {
		this.errorCode = code;
		this.errorMsg = msg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
