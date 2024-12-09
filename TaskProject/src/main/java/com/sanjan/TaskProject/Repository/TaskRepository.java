package com.sanjan.TaskProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanjan.TaskProject.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllByUsersId(long userId);

//	Task getByUsersIdAndtaskId(long userId, long taskId);
}
	