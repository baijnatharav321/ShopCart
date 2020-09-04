package com.shop.cart.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shop.cart.exceptions.CartEmptyException;
import com.shop.cart.exceptions.ProductNotFoundException;
import com.shop.cart.exceptions.UserNotFoundException;
import com.shop.cart.responce.CustomError;

@RestControllerAdvice
public class CartControllerExceptionAdvisor {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomError> userNotFoundException(UserNotFoundException userNotFoundException){
		CustomError custError = new CustomError(userNotFoundException.getMessage(), "204");
		return new ResponseEntity<CustomError>(custError,HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<CustomError> productNotFoundException(ProductNotFoundException productNotFoundException){
		CustomError custError = new CustomError(productNotFoundException.getMessage(), "204");
		return new ResponseEntity<CustomError>(custError,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<CustomError> cartEmptyException(CartEmptyException cartEmptyException){
		CustomError custError = new CustomError(cartEmptyException.getLocalizedMessage(), "204");
		return new ResponseEntity<CustomError>(custError, HttpStatus.ACCEPTED);
	}
}
