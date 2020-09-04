package com.shop.cart.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shop.cart.exceptions.UserNotFoundException;
import com.shop.cart.responce.CustomError;

@RestControllerAdvice
public class UserControllerExceptionAdvisor {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomError> userNotFoundException(UserNotFoundException userNotFoundException) {
		CustomError custError = new CustomError(userNotFoundException.getMessage(), "204");
		return new ResponseEntity<CustomError>(custError, HttpStatus.ACCEPTED);
	}
}
