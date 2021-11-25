package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

@Service
public class AddressBookService implements IAddressBookService{

	@Override
	public List<Contact> getContact() {
		List<Contact> contactList = new ArrayList<>();
		contactList.add(new Contact(1,
	                new ContactDTO("Sachin", "Tendulkar", "LalGanj", "Mumbai", "Maharashtra", "560000", "9631236547")));
        System.out.println(contactList.toString());

		return contactList;
	}

	@Override
	public Contact getContactById(int contactId) {
		Contact contact = new Contact(1,
                new ContactDTO("Rahul", "Dravid", "MG Road", "Bangalore", "Karnataka", "561210", "9123456789"));
        return contact;
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		Contact contact = new Contact(1, contactDTO);
		return contact;
	}

	@Override
	public Contact updateContact(int contactId, ContactDTO contactDTO) {
		Contact contact = new Contact(1, contactDTO);
		return contact;
	}

	@Override
	public void deleteContact(int contactId) {
		// TODO Auto-generated method stub
		
	}
	

}
