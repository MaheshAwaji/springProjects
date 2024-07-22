package com.te.spring_movies.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.spring_movies.exception.ActorNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {
	
	 @ExceptionHandler(ActorNotFoundException.class)
	 public ResponseEntity<String> handleEmptyInput(ActorNotFoundException actorNotFoundException){
		 return new ResponseEntity<String>("Actor is not present please look for other id",HttpStatus.BAD_REQUEST);
	 }
	

}
