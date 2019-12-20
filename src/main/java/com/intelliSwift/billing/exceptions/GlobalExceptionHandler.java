package com.intelliSwift.billing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptionHandler {	
	
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<BadCredentialsResponseDto> handlBadCredException(BadCredentialsException exception) {
	
		BadCredentialsResponseDto dto = new BadCredentialsResponseDto(exception.getMessage());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
	}
		
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestDto> handlBadRequestException(BadRequestException exception) {
	
		BadRequestDto dto = new BadRequestDto("The provided data contains invalid values");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}

	@ExceptionHandler({ RuntimeException.class, Exception.class })
	public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
	
		ErrorResponseDto dto = new ErrorResponseDto("Something went wrong");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
	}

}
