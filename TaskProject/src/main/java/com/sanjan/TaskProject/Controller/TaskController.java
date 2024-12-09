package com.sanjan.TaskProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sanjan.TaskProject.Payload.TaskDto;
import com.sanjan.TaskProject.Repository.TaskRepository;
import com.sanjan.TaskProject.Service.TaskService;

@RestController
@RequestMapping("/v1/sj")
public class TaskController {

	private TaskService taskService;
	
	@Autowired
	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@GetMapping("/task/msg")
	public String getMsg()
	{
		return "Hi from task class";
	}
	
	@PostMapping("/{userId}/task")
	public ResponseEntity<TaskDto> savetask(@PathVariable long userId, @RequestBody TaskDto taskDto)
	{
		return new ResponseEntity<>(taskService.saveTask(userId, taskDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}/task/all")
	public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable long userId)
	{
		return new ResponseEntity<List<TaskDto>>(taskService.getAllTasks(userId), HttpStatus.FOUND);
	}
	
	@GetMapping("/{userId}/{taskId}/idvl")
	public ResponseEntity<TaskDto> getUsersIndividualTask(@PathVariable long userId, @PathVariable long taskId)
	{
		return new ResponseEntity<TaskDto>(taskService.getUsersIndividualTask(userId, taskId),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/{userId}/{taskId}/del/task")
	public ResponseEntity<String> deleteUsersIndividualTask(@PathVariable long userId,@PathVariable long taskId)
	{
		taskService.deleteUsersIndividualTask(userId, taskId);
		return new ResponseEntity<String>("Task got deleted for this user...",HttpStatus.OK);
	}
}
