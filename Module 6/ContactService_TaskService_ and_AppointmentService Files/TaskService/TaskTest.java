//============================================================================
// Name        : TaskTest.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

	private Task task;

	// Preset variables for testing unit
	@BeforeEach
	void setUp() {
		task = new Task("ReadTask", "ReadingTaskID", "Executed Reading the TaskID");
	}

	// Testing if initial task was created
	@Test
	public void testTaskCreation() {
		assertEquals("ReadTask", task.getTaskID());
		assertEquals("ReadingTaskID", task.getTaskName());
		assertEquals("Executed Reading the TaskID", task.getTaskDescription());
	}

	// Test setters and ensure they correctly update the variables
	@Test
	void testSetters() {
		Task task = new Task("ReadTask", "ReadingTaskID", "Executed Reading the TaskID");
		task.setTaskName("ReadCustomerID");
		assertEquals("ReadCustomerID", task.getTaskName());
		task.setTaskDescription("Executed Reading the CustomerID");
		assertEquals("Executed Reading the CustomerID", task.getTaskDescription());
	}

	// When the task ID is too long, NULL, and empty
	@Test void testTaskID() { 
		assertThrows(IllegalArgumentException.class, () -> { 
			new Task("This initial task ID but the test will be too long to pass", "ReadingContactID", "Executed Reading the TaskID"); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> { 
			new Task(null, "ReadingTaskID", "Executed Reading the TaskID"); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> { 
			new Task("", "ReadingTaskID", "Executed Reading the TaskID"); 
		}); 
	}

	// When the task name is too long, NULL, and empty
	@Test
	void testTaskName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ReadTask", "This initialize task name field is supposed to be too long", "Executed Reading the TaskID");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ReadTask", null, "Executed Reading the TaskID");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ReadTask", "", "Executed Reading the TaskID");
		});
	}

	// When the task description is too long, NULL, and empty
	@Test
	void testTaskDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ReadTask", "ReadingTaskID", "This initialized description field will be too long to pass");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ReadTask", "ReadingTaskID", null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("ReadTask", "ReadingTaskID", "");
		});
	}

	// When the setTaskName is too long, NULL, and empty
	@Test 
	void testSetTaskNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName("This is the name field but it will fail because it is too long");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName(null); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskName("");
		});
	}

	// When the setTaskDescription is too long, NULL, and empty
	@Test
	void testSetTaskDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskDescription("This is where we need to include a description field but the test will be too long to pass");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskDescription(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			task.setTaskDescription("");
		});
	}
}