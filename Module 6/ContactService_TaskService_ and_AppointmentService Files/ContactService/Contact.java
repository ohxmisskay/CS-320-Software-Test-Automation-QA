//============================================================================
// Name        : Contact.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package ContactService;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String number;
	private String address;

	public Contact(String contactID, String firstName, String lastName, String number, String address) {

		// Ensures first name cannot be null or more than 10 characters or it will throw illegal argument exception
		if (validateInput(firstName, 10)) { 
			throw new IllegalArgumentException("Invalid task descripton"); 
		}
		// Ensures last name cannot be null or more than 10 characters or it will throw illegal argument exception
		if (validateInput(lastName, 10)) { 
			throw new IllegalArgumentException("Invalid task descripton"); 
		}	
		// Ensures phone number cannot be null or more than 10 characters or it will throw illegal argument exception
		if (validateDigitOnlyInput(number, 10)) { 
			throw new IllegalArgumentException("Invalid phone number"); 
		}
		// Ensures address cannot be null or more than 30 characters or it will throw illegal argument exception
		if (validateInput(address, 30)) { 
			throw new IllegalArgumentException("Invalid task descripton"); 
		}	

		// Use the current method for the variable
		this.contactId = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}

	// Assigns valid requirements to variables
	private boolean validateInput(String item, int length) {
		return item == null || item.length() > length || item.isBlank();
	}

	// Assigns valid requirements for phone number
	private boolean validateDigitOnlyInput(String item, int length) {
		return item == null || item.length() != 10 || !item.matches("\\d{10}");
	}

	// Getters
	public String getContactID() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getAddress() {
		return address;
	}

	// Mutators, replica of constructors
	// If first name does not meet requirements, throw illegal argument
	public void setFirstName(String firstName) {		
		if (validateInput(firstName, 10)) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// Else, sets the new first name
		else {
			this.firstName = firstName;
		}
	}

	// If last name does not meet requirements, throw illegal argument
	public void setLastName(String lastName) {
		if (validateInput(lastName, 10)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// Else, sets the new last name
		else {
			this.lastName = lastName;
		}
	}

	// If phone number does not meet requirements, throw illegal argument
	public void setNumber(String number) {
		if (validateDigitOnlyInput(number, 10)) { 
			throw new IllegalArgumentException("Invalid phone number"); 
		}
		// Else, sets the new phone number
		else {
			this.number = number;
		}
	}

	// If address does not meet requirements, throw illegal argument
	public void setAddress(String address) {
		if (validateInput(address, 30)) {
			throw new IllegalArgumentException("Invalid address field");
		}
		// Else, sets the new address 
		else {
			this.address = address;
		}
	}

}