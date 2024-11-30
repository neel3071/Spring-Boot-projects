package com.jbk.exceptions;

import java.security.Timestamp;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbk.dto.ExeptionResponce;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExpectionHandler {
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public HashMap<String, String> userExpection(MethodArgumentNotValidException ex) {
		HashMap<String, String> err = new HashMap<String, String>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		for(FieldError fieldError : fieldErrors) {
			err.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return err;
	}
	
	
	@ExceptionHandler(exception = ResorceNotFoundExpection.class)
	public ExeptionResponce ResorceNotFoundExpection(ResorceNotFoundExpection ex , HttpServletRequest req ) {
		ExeptionResponce exeptionResponce = new ExeptionResponce();
		exeptionResponce.setUsername(ex.getMessage());
		exeptionResponce.setPath(req.getRequestURI());
		exeptionResponce.setTimestamp(new java.sql.Timestamp(System.currentTimeMillis()));
		
		return exeptionResponce;
		
	}
	

}
