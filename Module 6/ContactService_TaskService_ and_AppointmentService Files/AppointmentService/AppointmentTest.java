//============================================================================
// Name        : AppointmentTest.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1 Project One Submission
//============================================================================

package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import Appointment.Appointment;

class AppointmentTest {
	
	LocalDate appointmentDate = LocalDate.now();

	private Appointment appointment;

	// Preset variables for testing unit
	@BeforeEach
	void setUp() {
		appointment = new Appointment("Dentist", appointmentDate, "Teeth Cleaning");
	}
	// Testing if initial appointment was created
	@Test
	public void testAppointmentCreation() {
		assertEquals("Dentist", appointment.getAppointmentID());
		assertEquals(LocalDate.now(), appointment.getAppointmentDate());
		assertEquals("Teeth Cleaning", appointment.getAppointmentDescription());
	}

	// Test setters and ensure they correctly update the variables
	@Test
	void testSetters() {
		Appointment appointment = new Appointment("Dentist", LocalDate.now(), "Teeth Cleaning");
		appointment.setAppointmentDate(appointmentDate.plusDays(4));
		assertEquals(appointmentDate.plusDays(4), appointment.getAppointmentDate());

		appointment.setAppointmentDescription("Teeth Cleaning and root canal");
		assertEquals("Teeth Cleaning and root canal", appointment.getAppointmentDescription());
	}
	
	// When the appointment ID is too long, NULL, or empty
	@Test void testAppointmentID() { 
		assertThrows(IllegalArgumentException.class, () -> { 
			new Appointment("This initial appointment ID but the test will be too long to pass", LocalDate.now(), "Teeth Cleaning"); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> { 
			new Appointment(null, LocalDate.now(), "Teeth Cleaning"); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> { 
			new Appointment("", LocalDate.now(), "Teeth Cleaning"); 
		}); 
	}

	// When the appointment date is too long, NULL, 20 days in the past.
	@Test
	void testAppointmentDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Dentist", LocalDate.now(), "This initialized description field will be too long to pass");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Dentist", null, "Teeth Cleaning");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Dentist", appointmentDate.minusDays(20), "Teeth Cleaning");
		});
	}

	// When the description is too long, null, and is empty
	@Test
	void testAppointmentDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Dentist", LocalDate.now(), "This initialized description field will be too long to pass");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Dentist", LocalDate.now(), null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("Dentist", LocalDate.now(), "");
		});
	}

	// When the setAppointmentDate is NULL and 30 years in the past
	@Test 
	void testSetAppointmentDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(null); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDate(appointmentDate.minusYears(30));
		});
	}

	// When the setAppointmentDescription is too long, NULL, and empty 
	@Test
	void testSetAppointmentDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDescription("This is where we need to include a description field but the test will be too long to pass");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDescription(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			appointment.setAppointmentDescription("");
		});
	}
}
