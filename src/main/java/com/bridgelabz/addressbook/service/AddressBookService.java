package com.bridgelabz.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.Util.TokenUtil;
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
	
	 @Autowired
	    TokenUtil tokenUtil;
	
	@Override
	public List<Contact> getContact() {
		
		return addressBookRepository.findAll();
	}

	@Override
	public Contact getContactById(String token) {
		
		return addressBookRepository.findById(tokenUtil.decodeToken(token))
				.orElseThrow(() -> new AddressBookException("Address book cont "+tokenUtil.decodeToken(token)+" does not exists"));
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		Contact contactData = new Contact(contactDTO);
		log.debug("Address book data ", contactData);
        contactData.createContactData(contactDTO);
		return addressBookRepository.save(contactData);
	}

	@Override
	public Contact updateContact(String token, ContactDTO contactDTO) {
		Contact contactData = this.getContactById(token);
		contactData.updateContact(contactDTO);
        return addressBookRepository.save(contactData);
	}

	@Override
	public void deleteContact(String token) {
		Contact contactData = this.getContactById(token);
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
	    
	    @Override
	    public Optional<Contact> getData(String token) {
	        
	        Optional<Contact> contactCheck = addressBookRepository.findById(tokenUtil.decodeToken(token));
	        if (contactCheck.isPresent()) {
	            Optional<Contact> contactData = addressBookRepository.findById(tokenUtil.decodeToken(token));
	            return contactData;
	        }
	        return null;
	    }

	    @Override
	    public List<Contact> getAllContacts(String token) {
	       
	        Optional<Contact> contactCheck = addressBookRepository.findById(tokenUtil.decodeToken(token));
	        if (contactCheck.isPresent()) {
	            List<Contact> contactList = addressBookRepository.findAll();
	            return contactList;
	        }
	        return null;
	    }
}
