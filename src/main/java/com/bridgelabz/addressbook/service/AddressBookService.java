package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

@Service
public class AddressBookService implements IAddressBookService{

    List<Contact> contactList = new ArrayList<>();

	@Override
	public List<Contact> getContact() {
		
		return contactList;
	}

	@Override
	public Contact getContactById(int contactId) {
		
        return contactList.get(contactId - 1);
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		System.out.println("Create Contact");
		List<Contact> contactData = this.getContact();
		System.out.println("ContactList: "+contactData.toString());
		contactList.add( new Contact(contactData.size() + 1, contactDTO));
		System.out.println(contactList.toString());
        return contactList.get(contactList.size() - 1);
	}

	@Override
	public Contact updateContact(int contactId, ContactDTO contactDTO) {
		Contact contact = this.getContactById(contactId);
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setAddress(contactDTO.getAddress());
        contact.setState(contactDTO.getState());
        contact.setCity(contactDTO.getCity());
        contact.setZip(contactDTO.getZip());
        contact.setPhone(contactDTO.getPhone());
        contactList.set(contactId - 1, contact);
        return contact;
	}

	@Override
	public void deleteContact(int contactId) {
		contactList.remove(contactId-1);
		
	}
}
