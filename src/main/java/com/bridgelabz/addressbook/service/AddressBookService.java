package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService{

	@Autowired
    private AddressBookRepository addressBookRepository;
	
	List<Contact> contactList = new ArrayList<Contact>();

	@Override
	public List<Contact> getContact() {
		
		return contactList;
	}

	@Override
	public Contact getContactById(int contactId) {
		
		return contactList.stream().filter(contact -> contact.getContactId() == contactId).findFirst()
                .orElseThrow(() -> new AddressBookException("Contact not found"));
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		Contact contactData = new Contact(contactList.size()+1, contactDTO);
		contactList.add(contactData);
		return addressBookRepository.save(contactData);
	}

	@Override
	public Contact updateContact(int contactId, ContactDTO contactDTO) {
		Contact contact = this.getContactById(contactId);
		contact.setFirstName(contactDTO.firstName);
        contact.setLastName(contactDTO.lastName);
        contact.setAddress(contactDTO.address);
        contact.setState(contactDTO.state);
        contact.setCity(contactDTO.city);
        contact.setZip(contactDTO.zip);
        contact.setPhone(contactDTO.phone);
        contactList.set(contactId - 1, contact);
        return contact;
	}

	@Override
	public void deleteContact(int contactId) {
		contactList.remove(contactId-1);
		
	}
}
