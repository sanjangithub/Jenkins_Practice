package com.sanjan.TaskProject.Service;

import java.util.List;

import com.sanjan.TaskProject.Payload.TaskDto;

public interface TaskService {

	public TaskDto saveTask(long userId, TaskDto taskDto);
	
	public List<TaskDto> getAllTasks(long userId);
	
	public TaskDto getUsersIndividualTask(long userId, long taskId);
	
	public void deleteUsersIndividualTask(long userId, long taskId);
}
