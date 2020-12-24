package com.techgig.women.test.Response;

import org.springframework.http.HttpStatus;

public class ResponseHelperWithHTTP {
	public static final HttpStatus getHttpStatus(String msg) {
		if(msg==null)
			return HttpStatus.OK;
		
		else if (msg.equals(MeetingConstant.RUN_TIME_ERROR)||msg.equals(MeetingConstant.FATAL_ERROR))
			return HttpStatus.INTERNAL_SERVER_ERROR;
		
		return HttpStatus.NOT_FOUND;
		
	}

}
