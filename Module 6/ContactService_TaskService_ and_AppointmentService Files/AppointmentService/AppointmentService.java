//============================================================================
// Name        : AppointmentService.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1 Project One Submission
//============================================================================

package Appointment;

import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;

public class AppointmentService {
	private Map<String, Appointment> appointments;

	public AppointmentService() {
		this.appointments = new HashMap<>();
	}

	// Adding new appointment
	public void addAppointment(Appointment appointment) {
		if(!appointments.containsKey(appointment.getAppointmentID())) {
			appointments.put(appointment.getAppointmentID(), appointment);
		}
		else {
			throw new IllegalArgumentException("Appointment ID already exists.");
		}
	}

	// Deleting appointmentID
	public void deleteAppointment(String appointmentID) {
		if (appointments.containsKey(appointmentID)) {
			appointments.remove(appointmentID);
		}
		else {
			throw new IllegalArgumentException("Appointment ID does not exist.");
		}
	}

	// Update the appointment date based on appointmentID
	public void updateAppointmentDate(String appointmentID, LocalDate newAppointmentDate) {
		if (appointments.containsKey(appointmentID)) {
			Appointment Appointment = appointments.get(appointmentID);
			Appointment.setAppointmentDate(newAppointmentDate);
		}
		else {
			throw new IllegalArgumentException("Cannot update appointment date");
		}
	}

	// Update the appointment description based on appointmentID
	public void updateAppointmentDescription(String appointmentID, String newAppointmentDescription) {
		if (appointments.containsKey(appointmentID)) {
			Appointment Appointment = appointments.get(appointmentID);
			Appointment.setAppointmentDescription(newAppointmentDescription);
		}
		else {
			throw new IllegalArgumentException("Cannot update appointment description");
		}
	}

	// Retrieve appointment information based on appointmentID
	public Appointment getAppointmentID(String appointmentID) {
		return appointments.get(appointmentID);
	}
}
