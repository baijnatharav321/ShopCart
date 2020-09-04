package com.shop.cart.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shop.cart.exceptions.ProductNotFoundException;
import com.shop.cart.responce.CustomError;


@RestControllerAdvice
public class ProductControllerExceptionAdvisor {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<CustomError> productNotFoundException(ProductNotFoundException exception) {
		CustomError customError = new CustomError(exception.getMessage(), "202");
		return new ResponseEntity<CustomError>(customError, HttpStatus.ACCEPTED);
	}
}
