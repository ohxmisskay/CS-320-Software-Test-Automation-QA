//============================================================================
// Name        : TaskService.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package Task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private Map<String, Task> tasks;

	public TaskService() {
		this.tasks = new HashMap<>();
	}

	// Adding a task if it does not exist in map, else throw illegal argument
	public void addTask(Task taskInput) {
		if(!tasks.containsKey(taskInput.getTaskID())) {
			tasks.put(taskInput.getTaskID(), taskInput);
		}
		else {
			throw new IllegalArgumentException("Task ID already exists.");
		}
	}

	// Deleting a task if it exist in the map, else throw illegal argument
	public void deleteTask(String taskID) {
		if (tasks.containsKey(taskID)) {
			tasks.remove(taskID);
		}
		else {
			throw new IllegalArgumentException("Task ID does not exist.");
		}
	}

	// Update the task name based on taskID, else throw illegal argument
	public void updateTaskName(String taskID, String newTaskName) {
		if (tasks.containsKey(taskID)) {
			Task task = tasks.get(taskID);
			task.setTaskName(newTaskName);
		}
		else {
			throw new IllegalArgumentException("Task name is invalid");
		}
	}

	// Update the task description based on taskID, else throw illegal argument
	public void updateTaskDescription(String taskID, String taskDescription) {
		if (tasks.containsKey(taskID)) {
			Task task = tasks.get(taskID);
			task.setTaskDescription(taskDescription);
		}
		else {
			throw new IllegalArgumentException("Task description is invalid");
		}
	}

	// Retrieve a task based on taskID, else return null if task cannot be found
	public Task getTask(String taskID) {
		return tasks.get(taskID);
	}
}
