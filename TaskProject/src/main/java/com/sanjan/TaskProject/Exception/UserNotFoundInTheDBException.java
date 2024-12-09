package com.sanjan.TaskProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundInTheDBException extends RuntimeException{

	public UserNotFoundInTheDBException(String msg) {
		super(msg);
	}
	
	public UserNotFoundInTheDBException() {
	}
}
