package com.cs320.projectone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * ContactServiceTest.java
 *
 * Unit tests for the ContactService class.
 * Verifies adding, deleting, and updating contact records with valid and invalid inputs.
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
        assertEquals("Marcus", newContact.getFirstName());
    }

    @Test
    void testAddDuplicateContactThrowsException() {
        Contact duplicate = new Contact("101", "Sophie", "Nguyen", "1231231234", "303 Ocean View Ln");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    @Test
    void testDeleteContact() {
        service.deleteContact("101");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("101");
        });
    }

    @Test
    void testDeleteNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
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
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("404", "Ghost");
        });
    }
}
