//============================================================================
// Name        : Appointment.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1 Project One Submission
//============================================================================

package Appointment;

import java.time.LocalDate;

public class Appointment {

	private final String appointmentID;
	private LocalDate appointmentDate;
	private String appointmentDescription;

	// Constructor
	public Appointment(String appointmentID, LocalDate appointmentDate, String appointmentDescription) {

		// Ensures appointment ID cannot be null or more than 10 characters or it will throw illegal argument exception
		if (validateInput(appointmentID, 10)) {
			throw new IllegalArgumentException("Invalid appointment ID"); 
		}

		// Ensures appointment date cannot be in the past and cannot be null or it will throw
		if (validateDateInput(appointmentDate, LocalDate.now())) {
			throw new IllegalArgumentException("Invalid appointment date.");
		}

		// Ensures appointment description cannot be null or more than 50 characters or it will throw illegal argument exception
		if (validateInput(appointmentDescription, 50)) {
			throw new IllegalArgumentException("Invalid appointment descripton"); 
		}

		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}

	// Assigns valid requirements to variables
	private boolean validateInput(String item, int length) {
		return item == null || item.length() > length || item.isBlank();
	}

	// Assigned valid requirements for appointment dates
	private boolean validateDateInput(LocalDate item, LocalDate localDate) {
		return item == null || item.isBefore(LocalDate.now());
	}

	// Getters
	public String getAppointmentID() {
		return appointmentID;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public String getAppointmentDescription() {
		return appointmentDescription;
	}

	// Mutators
	// If date does not meet requirements, throw illegal argument
	public void setAppointmentDate(LocalDate appointmentDate) {
		if (validateDateInput(appointmentDate, LocalDate.now())) {
			throw new IllegalArgumentException("Invalid appointment date.");
		}
		// Else, sets the new date
		else {
			this.appointmentDate = appointmentDate;
		}
	}

	// If description does not meet requirements, throw illegal argument
	public void setAppointmentDescription(String appointmentDescription) {
		if (validateInput(appointmentDescription, 50)) {
			throw new IllegalArgumentException("Invalid address field");
		}
		// Else, sets the new description 
		else {
			this.appointmentDescription = appointmentDescription;
		}
	}
}
