package com.cs320.projectone;

import java.util.HashMap;
import java.util.Map;


/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * ContactService.java
 *
 * Service class for managing Contact objects.
 * Supports adding, updating, and deleting contacts by their unique ID.
 * Uses in-memory data storage with validation handled by the Contact class.
 */

public class ContactService {

    // this map stores all contacts using contactId as the key
    private Map<String, Contact> contacts = new HashMap<>();

    // method to add a new contact
    public void addContact(Contact contact) {
        // check if the contact ID is already used
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        // add the contact to the map
        contacts.put(contact.getContactId(), contact);
    }

    // method to delete a contact by ID
    public void deleteContact(String contactId) {
        // check if contact exists
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        // remove contact
        contacts.remove(contactId);
    }

    // method to update first name by contact ID
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContact(contactId); // get contact or throw error
        contact.setFirstName(newFirstName); // use setter from Contact class
    }

    // method to update last name by contact ID
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(newLastName);
    }

    // method to update phone number by contact ID
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContact(contactId);
        contact.setPhone(newPhone);
    }

    // method to update address by contact ID
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContact(contactId);
        contact.setAddress(newAddress);
    }

    // private helper method to get contact or throw error if not found
    private Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        return contacts.get(contactId);
    }
}
