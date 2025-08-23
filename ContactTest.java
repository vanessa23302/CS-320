package com.cs320.projectone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * ContactTest.java
 *
 * Unit tests for the Contact class.
 * Verifies correct creation of Contact objects and validation of field constraints.
 */

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("101", "Lena", "Walker", "2223334444", "100 Sunset Dr");
        assertEquals("101", contact.getContactId());
        assertEquals("Lena", contact.getFirstName());
        assertEquals("Walker", contact.getLastName());
        assertEquals("2223334444", contact.getPhone());
        assertEquals("100 Sunset Dr", contact.getAddress());
    }

    @Test
    void testNullContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Lena", "Walker", "2223334444", "100 Sunset Dr");
        });
    }

    @Test
    void testLongContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Lena", "Walker", "2223334444", "100 Sunset Dr");
        });
    }

    @Test
    void testNullFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("101", null, "Walker", "2223334444", "100 Sunset Dr");
        });
    }

    @Test
    void testLongFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("101", "Alexandrianna", "Walker", "2223334444", "100 Sunset Dr");
        });
    }

    @Test
    void testInvalidPhoneThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("101", "Lena", "Walker", "22233", "100 Sunset Dr");
        });
    }

    @Test
    void testLongAddressThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("101", "Lena", "Walker", "2223334444", "5678 Extra Long Boulevard Name Way");
        });
    }

    @Test
    void testSettersWorkCorrectly() {
        Contact contact = new Contact("102", "Noah", "Green", "3334445555", "12 Hilltop Ln");

        contact.setFirstName("Eli");
        contact.setLastName("Bryant");
        contact.setPhone("8889990000");
        contact.setAddress("64 Cypress Creek Rd");

        assertEquals("Eli", contact.getFirstName());
        assertEquals("Bryant", contact.getLastName());
        assertEquals("8889990000", contact.getPhone());
        assertEquals("64 Cypress Creek Rd", contact.getAddress());
    }
}
