package com.cs320.projectone;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * CS 499 Capstone Enhancement
 * ContactServiceTest.java
 *
 * Unit tests for the ContactService class.
 * Verifies adding, deleting, updating, retrieving, and counting contacts
 * using the HashMap data structure.
 */
public class ContactServiceTest {

    private ContactService service;
    private Contact contact1;
    private Contact contact2;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact1 = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact2 = new Contact("456", "Jane", "Smith", "0987654321", "456 Oak Ave");
    }

    @Test
    void testAddContact() {
        service.addContact(contact1);
        assertEquals(contact1, service.findContactById("123"));
    }

    @Test
    void testAddDuplicateContactId() {
        service.addContact(contact1);

        Contact duplicate = new Contact("123", "Jake", "Brown", "1112223333", "789 Pine Rd");

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    @Test
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact1);
        service.deleteContact("123");

        assertThrows(IllegalArgumentException.class, () -> {
            service.findContactById("123");
        });
    }

    @Test
    void testDeleteNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact1);
        service.updateFirstName("123", "Jane");
        assertEquals("Jane", service.findContactById("123").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact1);
        service.updateLastName("123", "Smith");
        assertEquals("Smith", service.findContactById("123").getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact1);
        service.updatePhone("123", "0987654321");
        assertEquals("0987654321", service.findContactById("123").getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact1);
        service.updateAddress("123", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.findContactById("123").getAddress());
    }

    @Test
    void testFindContactById() {
        service.addContact(contact1);
        Contact found = service.findContactById("123");

        assertEquals("John", found.getFirstName());
        assertEquals("Doe", found.getLastName());
    }

    @Test
    void testFindContactByInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.findContactById("999");
        });
    }

    @Test
    void testFindContactByBlankId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.findContactById("   ");
        });
    }

    @Test
    void testGetAllContacts() {
        service.addContact(contact1);
        service.addContact(contact2);

        List<Contact> contacts = service.getAllContacts();

        assertEquals(2, contacts.size());
        assertTrue(contacts.contains(contact1));
        assertTrue(contacts.contains(contact2));
    }

    @Test
    void testGetContactCount() {
        service.addContact(contact1);
        service.addContact(contact2);

        assertEquals(2, service.getContactCount());
    }

    @Test
    void testGetContactCountEmpty() {
        assertEquals(0, service.getContactCount());
    }
}
