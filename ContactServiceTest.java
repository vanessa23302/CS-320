package com.cs320.projectone;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * ContactTest.java
 *
 * Unit tests for the Contact class.
 * Verifies valid object creation, field constraints, and setter behavior.
 */
public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testBlankContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("   ", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "LongFirstName", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    void testInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "LongLastName", "1234567890", "123 Main St");
        });
    }

    @Test
    void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    void testInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    void testSettersUpdateValues() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    void testSettersInvalidValues() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
