package com.droz.ftg.services.impl;

import com.droz.ftg.entities.Task;
import com.droz.ftg.services.TaskService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Date: 1/7/12
 *
 * @author Dima Rassin
 */
@Service
public class TaskServiceImpl implements TaskService {
	private Map<Long, Task> repository = new HashMap<>();

	private AtomicLong idSeq = new AtomicLong();

	@Override
	public Task createTask(Task task) {
		if (task.getId() == null) {
			// set ID by reflection
			for (Field field : Task.class.getDeclaredFields()) {
				if ("id".equals(field.getName())) {
					field.setAccessible(true);
					try {
						field.setLong(task, idSeq.incrementAndGet());
					} catch (IllegalAccessException e) {/* cannot occur since we set it as accessible */}
				}
			}
		}

		repository.put(task.getId(), task);

		return task;
	}

	@Override
	public void shareTask(Long taskId) {
	}

	@Override
	public List<Task> readPrivateTasks() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<Task> readTasksByDuration(int minutes) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
