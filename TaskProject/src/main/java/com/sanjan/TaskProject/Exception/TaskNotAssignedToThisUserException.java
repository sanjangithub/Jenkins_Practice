package com.sanjan.TaskProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TaskNotAssignedToThisUserException extends RuntimeException{

	public TaskNotAssignedToThisUserException(String msg) {
		super(msg);
	}
}
