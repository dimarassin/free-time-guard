package com.droz.ftg.services;

import com.droz.ftg.entities.Task;

import java.util.List;

/**
 * Date: 1/7/12
 *
 * @author Dima Rassin
 */
public interface TaskService {
	Task createTask(Task task);

	void shareTask(Long taskId);

	List<Task> readPrivateTasks();

	List<Task> readTasksByDuration(long minutes);
}
