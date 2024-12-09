package com.sanjan.TaskProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjan.TaskProject.Payload.UsersDto;
import com.sanjan.TaskProject.ServiceImpl.UsersServiceImpl;

@RestController
@RequestMapping("/v1/sj")
public class UsersController {

	private UsersServiceImpl usersServiceImpl;

	@Autowired
	public UsersController(UsersServiceImpl usersServiceImpl) {
		super();
		this.usersServiceImpl = usersServiceImpl;
	}
	
	@GetMapping("/user/msg")
	public String msg()
	{
		return "Hey Mama!";
	}
	
	@PostMapping("/user/add")
	public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto usersDto)
	{
		return new ResponseEntity<>(usersServiceImpl.createUser(usersDto), HttpStatus.CREATED);
	}
	
}
