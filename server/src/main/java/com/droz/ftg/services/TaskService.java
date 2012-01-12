package com.droz.ftg.services;

import com.droz.ftg.entities.Duration;
import com.droz.ftg.entities.Task;

import java.util.List;

/**
 * Date: 1/7/12
 *
 * @author Dima Rassin
 */
public interface TaskService {
	Task createTask(Task task);

	Task updateTask(Task task);

	void deleteTask(Long taskId);

	void shareTask(Long taskId);

	List<Task> readPrivateTasks();

	List<Task> readTasksByDuration(Duration duration);
}
