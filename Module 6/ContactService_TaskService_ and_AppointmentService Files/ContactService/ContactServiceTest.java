//============================================================================
// Name        : ContactServiceTest.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ContactService.Contact;
import ContactService.ContactService;

public class ContactServiceTest {

	private ContactService contactService;

	// Preset variables for testing unit
	@BeforeEach
	void setUp(){
		contactService = new ContactService();
		// Adding the first and second contact to the hash map
		Contact contact1 = new Contact("1", "Saul", "Goodman", "5055034455", "308 Negra Arroyo Lane");
		Contact contact2 = new Contact("2", "Homer", "Simpson", "5555557334", "742 Evergreen Terrace");
		contactService.addContact(contact1);
		contactService.addContact(contact2);
	}

	// When testing to add a new contact
	@Test
	void testAddContact() {
		Contact newContact = new Contact("3", "Dwight", "Schrute ", "8009843672", "Rural Rt. 6");
		contactService.addContact(newContact);
		assertEquals(newContact, contactService.getContact("3"));
	}

	// When testing each variable is updated, by using the first contactID
	@Test
	void testContactUpdates() {
		Contact updatedContact = contactService.getContact("1");
		contactService.updateFirstName("1", "Walter");
		assertEquals("Walter", updatedContact.getFirstName());
		contactService.updateLastName("1", "White");
		assertEquals("White", updatedContact.getLastName());
		contactService.updateNumber("1", "5555555555");
		assertEquals("5555555555", updatedContact.getNumber());
		contactService.updateAddress("1", "3828 Piermont Dr");
		assertEquals("3828 Piermont Dr", updatedContact.getAddress());
	}

	// When testing each variable is updated, without a valid contactID
	@Test
	void testUpdatesWithoutAValidContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("6", "Jim");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName("15", "Halpert");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateNumber("12", "111111111");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress("23", "930 Pacific Coast Highway");
		});
	}

	// When the contact is duplicated and not unique
	@Test
	void testContactIDIsDupilcated() {
		// Test if contact ID exists
		assertThrows(IllegalArgumentException.class, () -> {
			Contact duplicateContact = new Contact("1", "Saul", "Goodman", "5055034455", "308 Negra Arroyo Lane");
			contactService.addContact(duplicateContact);
		});
	}

	// When deleting the first contact
	@Test
	void testDeleteContact() {
		contactService.deleteContact("1");
		assertNull(contactService.getContact("1"));
	}

	// When deleting the contact, without a valid contact ID
	@Test
	void testDeleteContactWithoutAValidContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("Insert Contact");
		});

	}

}