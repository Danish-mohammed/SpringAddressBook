package com.bridgelabz.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

	@Autowired
    private AddressBookRepository addressBookRepository;
	
	@Override
	public List<Contact> getContact() {
		
		return addressBookRepository.findAll();
	}

	@Override
	public Contact getContactById(int contactId) {
		
		return addressBookRepository.findById(contactId)
				.orElseThrow(() -> new AddressBookException("Address book cont "+contactId+" does not exists"));
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		Contact contactData = new Contact(contactDTO);
		log.debug("Address book data ", contactData);
		return addressBookRepository.save(contactData);
	}

	@Override
	public Contact updateContact(int contactId, ContactDTO contactDTO) {
		Contact contactData = this.getContactById(contactId);
		contactData.updateContact(contactDTO);
        return addressBookRepository.save(contactData);
	}

	@Override
	public void deleteContact(int contactId) {
		Contact contactData = this.getContactById(contactId);
		addressBookRepository.delete(contactData);		
	}
	
	 @Override
	    public String deleteAllAddressBookData() {
	        addressBookRepository.deleteAll();
	        return "Successfully deleted all the Contacts from AddressBook";
	    }

	    @Override
	    public List<Contact> getContactByCity(String city) {
	        return addressBookRepository.findContactListByCity(city);
	    }

	    @Override
	    public List<Contact> getContactByFirstName(String firstName) {
	        return addressBookRepository.findContactListByFirstName(firstName);
	    }

	    @Override
	    public List<Contact> getContactByLastName(String lastName) {
	        return addressBookRepository.findContactListByLastName(lastName);
	    }

	    @Override
	    public List<Contact> getContactByPincode(String zip) {
	        return addressBookRepository.findContactListByZip(zip);
	    }

	    @Override
	    public List<Contact> sortByName() {
	        return addressBookRepository.sortByName();
	    }

	    @Override
	    public List<Contact> sortByCity() {
	        return addressBookRepository.sortByCity();
	    }

	    @Override
	    public List<Contact> sortByPincode() {
	        return addressBookRepository.sortByPincode();
	    }
}
