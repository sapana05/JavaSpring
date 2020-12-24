package com.techgig.women.test.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response<T> {

	private T data;
	private String errorMsg;
	public Response(T data) {
		super();
		this.data = data;
	}
	
	public Response(T data,String status) {
		super();
		if(!status.equalsIgnoreCase(MeetingConstant.SUCCESS)) {
			this.errorMsg=status;
		}
		this.data = data;
	}
public T getData() {
	return data;
}
	public String getErrorMsg() {
		return errorMsg;
	}	
	
}
