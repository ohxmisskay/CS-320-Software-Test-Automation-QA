//============================================================================
// Name        : TaskServiceTest.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	private TaskService taskService;

	// Preset variables for testing unit
	@BeforeEach
	void setUp(){
		taskService = new TaskService();
		// Adding the first and second task to the hash map
		Task task1 = new Task("ReadTask", "ReadingTaskID", "Executed Reading the TaskID");
		Task task2 = new Task("ReadTask2", "ReadingTaskID2", "Executed Reading the TaskID2");
		taskService.addTask(task1);
		taskService.addTask(task2);
	}

	// When testing to add a new task
	@Test
	void testAddTask() {
		Task newTask = new Task("ReadTask3", "ReadingTaskID3", "Executed Reading the TaskID3");
		taskService.addTask(newTask);
		assertEquals(newTask, taskService.getTask("ReadTask3"));
	}

	// When testing each variable is updated, by using the first taskID
	@Test
	void testTaskUpdates() {
		Task updatedTask = taskService.getTask("ReadTask");
		taskService.updateTaskName("ReadTask", "ReadingCustomerID");
		assertEquals("ReadingCustomerID", updatedTask.getTaskName());
		taskService.updateTaskDescription("ReadTask", "Executed Reading the CustomerID");
		assertEquals("Executed Reading the CustomerID", updatedTask.getTaskDescription());
	}

	// When testing each variable is updated, without a valid taskID
	@Test
	void testTaskUpdatesWithoutAValidContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskName("Insert Task", "ReadingCustomerID");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTaskDescription("Insert Task", "Executed Reading the CustomerID");
		});
	}

	// When the task ID is duplicated and not unique
	@Test
	void testTaskIDIsDupilcated() {
		// Test if task ID exists
		assertThrows(IllegalArgumentException.class, () -> {
			Task duplicateTask = new Task("ReadTask", "ReadingTaskID", "Executed Reading the TaskID");
			taskService.addTask(duplicateTask);
		});
	}

	// When deleting the first task
	@Test
	void testDeleteTask() {
		taskService.deleteTask("ReadTask");
		assertNull(taskService.getTask("ReadTask"));
	}

	// When deleting the first task, without a valid task ID
	@Test
	void testUpdatedDeleteTasWithoutATaskID() {
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("Insert Task");
		});

	}
}