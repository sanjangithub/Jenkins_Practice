package com.sanjan.TaskProject.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjan.TaskProject.Entity.Users;
import com.sanjan.TaskProject.Payload.UsersDto;
import com.sanjan.TaskProject.Repository.UsersRepository;
import com.sanjan.TaskProject.Service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersRepository usersRepository;
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@Override
	public UsersDto createUser(UsersDto usersDto) {
		Users saveduser = usersRepository.save(changingFromUsersDtoToUsersEntity(usersDto));
		return changingFromUsersEntityToUsersDto(saveduser);
	}
	
	private Users changingFromUsersDtoToUsersEntity(UsersDto usersDto)
	{
		Users users = new Users();
		users.setName(usersDto.getName());
		users.setEmail(usersDto.getEmail());
		users.setPassword(usersDto.getPassword());
		
		return users;
	}
	
	private UsersDto changingFromUsersEntityToUsersDto(Users users)
	{
		UsersDto dto = new UsersDto();
		dto.setName(users.getName());
		dto.setEmail(users.getEmail());
		dto.setPassword(users.getPassword());
		
		return dto;
	}
}
