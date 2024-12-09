package com.sanjan.TaskProject.Payload;

public class TaskDto {
 
	private long task_id;
	
	private String taskName;

	public long getTask_id() {
		return task_id;
	}

	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public TaskDto(long task_id, String taskName) {
		super();
		this.task_id = task_id;
		this.taskName = taskName;
	}

	@Override
	public String toString() {
		return "TaskDto [task_id=" + task_id + ", taskName=" + taskName + "]";
	}
	
	public TaskDto() {}
}
