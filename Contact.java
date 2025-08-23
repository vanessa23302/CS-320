package com.cs320.projectone;

/**
 * Vanessa Sanchez
 * CS 320 - Software Testing Automation & QA
 * Contact.java
 *
 * Represents a contact with a unique ID, first name, last name, phone number, and address.
 * Includes validation for each field according to project requirements.
 */



public class Contact {

    // contactId can't be changed once set
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // constructor to set up the contact with required info
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // check if contactId is valid (not null and max 10 characters)
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        this.contactId = contactId;

        // set each field using the setter to check rules
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // get the contact ID (can't be changed)
    public String getContactId() {
        return contactId;
    }

    // get the first name
    public String getFirstName() {
        return firstName;
    }

    // get the last name
    public String getLastName() {
        return lastName;
    }

    // get the phone number
    public String getPhone() {
        return phone;
    }

    // get the address
    public String getAddress() {
        return address;
    }

    // change first name (must be valid)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // change last name (must be valid)
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // change phone number (must be exactly 10 digits)
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.phone = phone;
    }

    // change address (must be valid)
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}

