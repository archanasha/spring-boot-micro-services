package com.timetrain.springweb.springweb.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.timetrain.springweb.springweb.dto.ExceptionResponse;

@ControllerAdvice
@RestController
public class  CutomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,
			WebRequest request) throws Exception {
	
		ExceptionResponse exceptionResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity(exceptionResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFounExceptions(Exception ex,
			WebRequest request) throws Exception {
	
		ExceptionResponse exceptionResp = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	
		return new ResponseEntity(exceptionResp, HttpStatus.NOT_FOUND);
	}
}
