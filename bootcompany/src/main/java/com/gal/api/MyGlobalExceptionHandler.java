package com.gal.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> returnNotValidArgument(MethodArgumentNotValidException ex) {
		log.error("exception is : {}" + ex);
		Map<String, String> map = new HashMap<>();
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for(FieldError err : fieldErrors) {
			map.put(err.getField(), err.getDefaultMessage());
		}
		map.put("code", ""+HttpStatus.BAD_REQUEST);
		ResponseEntity<Map<String, String>> re = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		return re;
	}
}
