package com.sanjan.TaskProject.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjan.TaskProject.Entity.Task;
import com.sanjan.TaskProject.Entity.Users;
import com.sanjan.TaskProject.Exception.TaskNotAssignedToThisUserException;
import com.sanjan.TaskProject.Exception.TaskNotFoundInTheDBException;
import com.sanjan.TaskProject.Exception.UserNotFoundInTheDBException;
import com.sanjan.TaskProject.Payload.TaskDto;
import com.sanjan.TaskProject.Repository.TaskRepository;
import com.sanjan.TaskProject.Repository.UsersRepository;
import com.sanjan.TaskProject.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	private ModelMapper modelMapper;
	
	private UsersRepository usersRepository;
	
	private TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(ModelMapper modelMapper, UsersRepository usersRepository, TaskRepository taskRepository) {
		super();
		this.modelMapper = modelMapper;
		this.usersRepository = usersRepository;
		this.taskRepository = taskRepository;
	}

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {
		Users user = usersRepository.findById(userId).orElseThrow(()-> new UserNotFoundInTheDBException("This User is not in the DB!"));
		Task task = modelMapper.map(taskDto,Task.class);
		task.setUsers(user);
//		After setting the user, We are storing the data in db!
		Task savedTask = taskRepository.save(task);
		return modelMapper.map(savedTask, TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(long userId) {
		usersRepository.findById(userId).orElseThrow(()-> new UserNotFoundInTheDBException("This User is not in the DB!"));
		List<Task> tasks = taskRepository.findAllByUsersId(userId);
		List<TaskDto> newtasksList = tasks.stream().map(i -> modelMapper.map(i, TaskDto.class)).collect(Collectors.toList());
		return newtasksList;
   }

	@Override
	public TaskDto getUsersIndividualTask(long userId, long taskId) {
		Users user = usersRepository.findById(userId).orElseThrow(() -> new TaskNotFoundInTheDBException("This task is not in the DB!"));
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundInTheDBException("This task is not in the DB!"));
		if(user.getId() != task.getUsers().getId())
		{
			throw new TaskNotAssignedToThisUserException("This task was not assigned to the user!");
		}
//		Task userIndividualTask = taskRepository.getByUsersIdAndtaskId(userId, taskId);
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteUsersIndividualTask(long userId, long taskId) {
		Users user = usersRepository.findById(userId).orElseThrow(() -> new TaskNotFoundInTheDBException("This task is not in the DB!"));
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundInTheDBException("This task is not in the DB!"));
		if(user.getId() != task.getUsers().getId())
		{
			throw new TaskNotAssignedToThisUserException("This task was not assigned to the user!");
		}
		taskRepository.deleteById(taskId);
	}
}
