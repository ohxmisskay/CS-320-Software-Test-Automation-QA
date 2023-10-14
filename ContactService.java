//============================================================================
// Name        : ContactService.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts;

	public ContactService() {
		this.contacts = new HashMap<>();
	}

	// Adding new contact
	public void addContact(Contact contact) {
		if(!contacts.containsKey(contact.getContactID())) {
			contacts.put(contact.getContactID(), contact);
		}
		else {
			throw new IllegalArgumentException("Contact ID already exists.");
		}
	}

	// Deleting contact
	public void deleteContact(String contactId) {
		if (contacts.containsKey(contactId)) {
			contacts.remove(contactId);
		}
		else {
			throw new IllegalArgumentException("Contact ID does not exist.");
		}
	}

	// Update the first name of a contact based on contactID
	public void updateFirstName(String contactID, String newFirstName) {
		if (contacts.containsKey(contactID)) {
			Contact contact = contacts.get(contactID);
			contact.setFirstName(newFirstName);
		}
		else {
			throw new IllegalArgumentException("First name is invalid");
		}
	}

	// Update the last name of a contact based on contactID
	public void updateLastName(String contactID, String newLastName) {
		if (contacts.containsKey(contactID)) {
			Contact contact = contacts.get(contactID);
			contact.setLastName(newLastName);
		}
		else {
			throw new IllegalArgumentException("Last name is invalid");
		}
	}

	// Update the phone number of a contact based on contactID
	public void updateNumber(String contactID, String newPhone) {
		if (contacts.containsKey(contactID)) {
			Contact contact = contacts.get(contactID);
			contact.setNumber(newPhone);
		}
		else {
			throw new IllegalArgumentException("Phone number is invalid");
		}
	}

	// Update the address of a contact based on contactID
	public void updateAddress(String contactID, String newAddress) {
		if (contacts.containsKey(contactID)) {
			Contact contact = contacts.get(contactID);
			contact.setAddress(newAddress);
		}
		else {
			throw new IllegalArgumentException("Address is invalid");
		}
	}

	// Retrieve contact information based on contactID
	public Contact getContact(String contactID) {
		return contacts.get(contactID);
	}
}