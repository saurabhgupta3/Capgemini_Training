package com.gal.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);
	@ExceptionHandler(exception = DepartmentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionDetailsDTO getExceptionDetails(DepartmentNotFoundException e) {
		log.error("exception is : {}", e);
		ExceptionDetailsDTO obj = new ExceptionDetailsDTO();
		obj.setMessage(e.getMessage());
	    return obj;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ExceptionDetailsDTO getExceptionDetails(Exception e) {
		ExceptionDetailsDTO obj = new ExceptionDetailsDTO();
		obj.setMessage(e.getMessage());
	    return obj;
	}
}
