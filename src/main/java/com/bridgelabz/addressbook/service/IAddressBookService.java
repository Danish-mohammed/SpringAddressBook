package com.bridgelabz.addressbook.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

public interface IAddressBookService {
	List<Contact> getContact();

    Contact getContactById(String token);

    Contact createContact(ContactDTO contactDTO);

    Contact updateContact(String token, ContactDTO contactDTO);

    void deleteContact(String token);
    String deleteAllAddressBookData();

    List<Contact> getContactByCity(String city);

    List<Contact> getContactByFirstName(String firstName);

    List<Contact> getContactByLastName(String lastName);

    List<Contact> getContactByPincode(String zip);

    List<Contact> sortByName();

    List<Contact> sortByCity();

    List<Contact> sortByPincode();
    
    Optional<Contact> getData(String token);

    List<Contact> getAllContacts(String token);
}
