//============================================================================
// Name        : AppointmentServiceTest.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1 Project One Submission
//============================================================================

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;


class AppointmentServiceTest {

	private AppointmentService appointmentService;

	LocalDate appointmentDate = LocalDate.now();
	LocalDate appointmentDate2 = LocalDate.of(2023, 10, 22);
	LocalDate appointmentDate3 = LocalDate.of(2023, 11, 28);

	// Preset variables for testing unit
	@BeforeEach
	void setUp(){
		appointmentService = new AppointmentService();
		// Adding the first and second appointment of the hash map
		Appointment appointment1 = new Appointment("Dentist", appointmentDate, "Teeth Cleaning");
		Appointment appointment2 = new Appointment("Homework", appointmentDate2, "Module 8 Assignments Due");
		appointmentService.addAppointment(appointment1);
		appointmentService.addAppointment(appointment2);
	}

	// When testing to add a new appointment
	@Test
	void testAddAppointment() {
		Appointment newAppointment = new Appointment("Turkey", appointmentDate3, "Family Fun Turkey Dinner");
		appointmentService.addAppointment(newAppointment);
		assertEquals(newAppointment, appointmentService.getAppointmentID("Turkey"));
	}

	// When updating the appointment date by 14 days, using the first appointment
	@Test
	void testUpdatedAppointmentDate() {
		appointmentService.updateAppointmentDate("Dentist", appointmentDate.plusDays(14));
		Appointment updatedAppointment = appointmentService.getAppointmentID("Dentist");
		assertEquals(appointmentDate.plusDays(14), updatedAppointment.getAppointmentDate());
	}

	// When testing the updated description, using the first appointment
	@Test
	void testUpdatedAppointmentDescription() {
		appointmentService.updateAppointmentDescription("Dentist", "Teeth cleaning and root canal");
		Appointment updatedAppointment = appointmentService.getAppointmentID("Dentist");
		assertEquals("Teeth cleaning and root canal", updatedAppointment.getAppointmentDescription());
	}

	// When testing each variable is updated, without a valid appointment ID
	@Test
	void testUpdatesWithoutAValidAppointmentID() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.updateAppointmentDate("BBALL", appointmentDate.plusDays(14));
		});
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.updateAppointmentDescription("15", "Insert Description");
		});
	}


	// When the appointment is duplicated and not unique
	@Test
	void testAppointmentIDIsDupilcated() {
		// Test if appointment ID exists
		assertThrows(IllegalArgumentException.class, () -> {
			Appointment duplicateAppointment = new Appointment("Dentist", appointmentDate, "Teeth Cleaning");
			appointmentService.addAppointment(duplicateAppointment);
		});
	}

	// When deleting the first appointment
	@Test
	void testDeleteAppointment() {
		appointmentService.deleteAppointment("Dentist");
		assertNull(appointmentService.getAppointmentID("Dentist"));
	}

	// When deleting the appointment, without a valid appointment ID
	@Test
	void testDeleteContactWithoutAValidContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("Insert App ID");
		});

	}
}
