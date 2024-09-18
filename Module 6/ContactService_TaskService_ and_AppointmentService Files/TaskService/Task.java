//============================================================================
// Name        : Task.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package Task;

public class Task {

	private final String taskID;
	private String taskName;
	private String taskDescription;

	public Task(String taskID, String taskName, String taskDescription) {
		// Ensures task ID cannot be null or more than 10 characters or it will throw illegal argument exception
		if (validateInput(taskID, 10)) { 
			throw new IllegalArgumentException("Invalid task ID"); }

		// Ensures task name cannot be null or more than 20 characters or it will throw illegal argument exception
		if (validateInput(taskName, 20)) {
			throw new IllegalArgumentException("Invalid task name"); 
		} 
		// Ensures task description cannot be null or more than 50 characters or it will throw illegal argument exception
		if (validateInput(taskDescription, 50)) { 
			throw new IllegalArgumentException("Invalid task descripton"); 
		}

		this.taskID = taskID;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}

	// Assigns valid requirements to variables
	private boolean validateInput(String item, int length) {
		if (item == null || item.length() > length || item.isBlank()) {
			return true;
		}
		return false;
	}

	// Getters
	public String getTaskID() {
		return taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	// Mutators
	// If task name does not meet requirements, throw illegal argument
	public void setTaskName(String taskName) {
		if (validateInput(taskName, 20)) {
			throw new IllegalArgumentException("Invalid task name");
		}
		// Else, sets the new task name
		else {
			this.taskName = taskName;
		}
	}


	// If task description does not meet requirements, throw illegal argument
	public void setTaskDescription(String taskDescription) {
		if (validateInput(taskDescription, 50)) {
			throw new IllegalArgumentException("Invalid description field");
		}
		// Else, sets the new task description
		else {
			this.taskDescription = taskDescription;
		}
	}
}