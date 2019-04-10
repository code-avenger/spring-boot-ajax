package com.app.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	
   @ExceptionHandler(value = NullPointerException.class)
   public ResponseEntity<Object> sqlException(NullPointerException exception) {
	   System.out.println("null pointer initiated");
	return new ResponseEntity<>("you have sent null values", HttpStatus.BAD_REQUEST);
   }
   
   @ExceptionHandler(value = ArithmeticException.class)
   public ResponseEntity<Object> sqlException(ArithmeticException exception) {
	   System.out.println("arithmatin initiated");
	return new ResponseEntity<Object>("there some internal issue", HttpStatus.CONFLICT);
   }
}
