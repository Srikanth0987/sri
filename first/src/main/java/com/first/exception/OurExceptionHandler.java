package com.first.exception;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class OurExceptionHandler {
		
	@ExceptionHandler(DefalutNameException.class)
	public ResponseEntity handleExcpetion(DefalutNameException ie)
		{
		ie.printStackTrace();
		System.out.println("DefalutNameException:::");
		ResponseEntity	responseEntity=new ResponseEntity(HttpStatus.CONFLICT);
		
		return  responseEntity;

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleExcpetion1(Exception e)
		{
		System.out.println("Exception...");
		e.printStackTrace();
		ResponseEntity	responseEntity=new ResponseEntity(HttpStatus.CONFLICT);
		
		return  responseEntity;

	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity handleExcpetion2(AccessDeniedException e)
		{
		e.printStackTrace();
		System.out.println("AccessDeniedException::");
		
	   ResponseEntity	responseEntity=new ResponseEntity(HttpStatus.UNAUTHORIZED);
		
		return  responseEntity;

	}
	
	
}
