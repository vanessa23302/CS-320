package com.cs320.projectone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * ContactServiceTest.java
 *
 * Unit tests for the ContactService class.
 * Verifies adding, deleting, updating, and retrieving contact records.
 */
public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("101", "Lena", "Walker", "2223334444", "100 Sunset Dr");
        service.addContact(contact);
    }

    @Test
    void testAddContact() {
        Contact newContact = new Contact("102", "Marcus", "Stone", "9998887777", "42 Riverbend Rd");
        service.addContact(newContact);
        assertEquals("Marcus", service.findContactById("102").getFirstName());
    }

    @Test
    void testAddDuplicateContactThrowsException() {
        Contact duplicate = new Contact("101", "Sophie", "Nguyen", "1231231234", "303 Ocean View Ln");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    void testAddNullContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testDeleteContact() {
        service.deleteContact("101");
        assertThrows(IllegalArgumentException.class, () -> service.findContactById("101"));
    }

    @Test
    void testDeleteNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    @Test
    void testDeleteNullContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
    }

    @Test
    void testUpdateFirstName() {
        service.updateFirstName("101", "Tina");
        assertEquals("Tina", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.updateLastName("101", "Lopez");
        assertEquals("Lopez", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.updatePhone("101", "7776665555");
        assertEquals("7776665555", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.updateAddress("101", "77 Maplewood Ave");
        assertEquals("77 Maplewood Ave", contact.getAddress());
    }

    @Test
    void testUpdateNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("404", "Ghost"));
    }

    @Test
    void testFindContactById() {
        Contact found = service.findContactById("101");
        assertEquals("Lena", found.getFirstName());
    }

    @Test
    void testGetAllContacts() {
        Contact secondContact = new Contact("102", "Marcus", "Stone", "9998887777", "42 Riverbend Rd");
        service.addContact(secondContact);

        List<Contact> contacts = service.getAllContacts();
        assertEquals(2, contacts.size());
    }
}
