package com.cs320.projectone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * ContactService.java
 *
 * Service class for managing Contact objects.
 * Supports adding, updating, deleting, and retrieving contacts
 * by their unique ID using in-memory storage.
 */
public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     *
     * @param contact the contact to add
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        String contactId = contact.getContactId();
        validateContactId(contactId);

        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }

        contacts.put(contactId, contact);
    }

    /**
     * Deletes a contact by ID.
     *
     * @param contactId unique contact ID
     */
    public void deleteContact(String contactId) {
        validateContactId(contactId);

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(newFirstName);
    }

    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(newLastName);
    }

    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContact(contactId);
        contact.setPhone(newPhone);
    }

    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContact(contactId);
        contact.setAddress(newAddress);
    }

    /**
     * Returns a contact by ID.
     *
     * @param contactId unique contact ID
     * @return matching Contact
     */
    public Contact findContactById(String contactId) {
        return getContact(contactId);
    }

    /**
     * Returns all contacts currently stored in the service.
     *
     * @return list of contacts
     */
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }

    private Contact getContact(String contactId) {
        validateContactId(contactId);

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }

        return contacts.get(contactId);
    }

    private void validateContactId(String contactId) {
        if (contactId == null || contactId.isBlank()) {
            throw new IllegalArgumentException("Contact ID cannot be null or blank");
        }
    }
}
