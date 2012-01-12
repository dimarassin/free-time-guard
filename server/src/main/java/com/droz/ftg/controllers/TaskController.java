package com.droz.ftg.controllers;

import com.droz.ftg.entities.Task;
import com.droz.ftg.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.List;

/**
 * Date: 1/8/12
 *
 * @author Dima Rassin
 */
@Controller
public final class TaskController {

	@Resource
	private String JSON_VIEW_NAME;

	@Autowired
	private TaskService taskService;

	@RequestMapping(method = RequestMethod.GET, value = "/tasks/private")
	public ModelAndView getPrivateTasks() {
		List<Task> tasks = taskService.readPrivateTasks();
		return new ModelAndView("jsonView", BindingResult.MODEL_KEY_PREFIX + "task", tasks);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/task")
	public ModelAndView createTask(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		Task task = (Task) null; // unmarshal(source);
		taskService.createTask(task);
		return new ModelAndView(JSON_VIEW_NAME, "object", task);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/task/{id}")
	public ModelAndView updateTask(@RequestBody String body) {
		Source source = new StreamSource(new StringReader(body));
		Task task = (Task) null; // unmarshal(source);
		taskService.updateTask(task);
		return new ModelAndView(JSON_VIEW_NAME, "object", task);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/task/{id}")
	public void removeTask(@PathVariable String id) {
		taskService.deleteTask(Long.parseLong(id));
	}
}
