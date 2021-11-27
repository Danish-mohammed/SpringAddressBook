package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

public interface IAddressBookService {
	List<Contact> getContact();

    Contact getContactById(int contactId);

    Contact createContact(ContactDTO contactDTO);

    Contact updateContact(int contactId, ContactDTO contactDTO);

    void deleteContact(int contactId);
    String deleteAllAddressBookData();

    List<Contact> getContactByCity(String city);

    List<Contact> getContactByFirstName(String firstName);

    List<Contact> getContactByLastName(String lastName);

    List<Contact> getContactByPincode(String zip);

    List<Contact> sortByName();

    List<Contact> sortByCity();

    List<Contact> sortByPincode();
}
