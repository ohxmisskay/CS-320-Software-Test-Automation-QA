//============================================================================
// Name        : ContactTest.Java
// Author      : Winnie Kwong
// Class       : CS-320 Software Test Automation & QA
// Instructor  : Professor Toledo
// Description : 6-1: Project One
//============================================================================

package Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ContactService.Contact;

public class ContactTest {

	private Contact contact;

	// Preset variables for testing unit
	@BeforeEach
	void setUp() {
		contact = new Contact("1", "Saul", "Goodman", "5055034455", "308 Negra Arroyo Lane");
	}

	// Testing if initial Contact was created
	@Test
	public void testContactCreation() {
		assertEquals("1", contact.getContactID());
		assertEquals("Saul", contact.getFirstName());
		assertEquals("Goodman", contact.getLastName());
		assertEquals("5055034455", contact.getNumber());
		assertEquals("308 Negra Arroyo Lane", contact.getAddress());
	}

	// Test setters and ensure they correctly update the variables
	@Test
	void testSetters() {
		Contact contact = new Contact("1", "Saul", "Goodman", "5055034455", "308 Negra Arroyo Lane");
		contact.setFirstName("Walter");
		assertEquals("Walter", contact.getFirstName());

		contact.setLastName("White");
		assertEquals("White", contact.getLastName());

		contact.setNumber("1234567890");
		assertEquals("1234567890", contact.getNumber());

		contact.setAddress("123 Fake Street");
		assertEquals("123 Fake Street", contact.getAddress());
	}

	// When the first name is too long, NULL, or empty
	@Test
	void testFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "SaulGoodman", "Goodman", "5055034455", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Goodman", "5055034455", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "", "Goodman", "5055034455", "308 Negra Arroyo Lane");
		});
	}

	// When the Last name too long, NULL, or empty
	@Test
	void testLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "'SaulGoodman", "5055034455", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", null, "5055034455", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "", "5055034455", "308 Negra Arroyo Lane");
		});
	}

	// When the phone number is too short, too long, NULL, empty, and non-digit/letters
	@Test
	void testNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "'Goodman", "12345", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "'Goodman", "123456789101112", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "Goodman", null, "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "Goodman", "", "308 Negra Arroyo Lane");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "Goodman", "ABCDEFGHIJ", "308 Negra Arroyo Lane");
		});
	}


	// When address is too long, NULL, and empty
	@Test
	void testAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "'Goodman", "5055034455", "3828 Piermont Dr, Albuquerque, NM");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "Goodman", "5055034455", null);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Saul", "Goodman", "5055034455", "");
		});
	}

	// When setFirstName is too long, NULL, and empty
	@Test 
	void testSetFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("SaulGoodman");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null); 
		}); 
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("");
		});
	}

	// When setLastName is too long, NULL, and empty
	@Test
	void testSetLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("SaulGoodman");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("");
		});
	}

	// When setNumber is NULL, empty, non-digit/letters, and not exactly 10 characters
	@Test
	void testSetNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setNumber(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setNumber("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setNumber("ABCDEFGHIJ");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setNumber("12345678910");
		});
	}

	// When setAddress is NULL, empty, or too long
	@Test
	void testSetAddress(){
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("3828 Piermont Dr, Albuquerque, NM");
		});
	}

}