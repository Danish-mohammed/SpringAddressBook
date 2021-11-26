package com.bridgelabz.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;

@RestController
@RequestMapping("/addressbookhome")
public class AddressBookController {
	
	@Autowired
    private IAddressBookService addressbookservice;
	
	@RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {

        List<Contact> contactData = addressbookservice.getContact();
        System.out.println(contactData.toString());
        ResponseDTO response = new ResponseDTO("Get call success", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

	
	 @GetMapping("/get/{contactId}")
	    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {
		 Contact contactData = addressbookservice.getContactById(contactId);
	        ResponseDTO response = new ResponseDTO("Get call success for id", contactData);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PostMapping("/create")
	    public ResponseEntity<ResponseDTO> createContactData(@RequestBody ContactDTO contactDTO) {
	        Contact contactData = addressbookservice.createContact(contactDTO);
	        System.out.println(contactData.toString());
	        ResponseDTO response = new ResponseDTO("Created contact data for", contactData);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PutMapping("/update/{contactId}")
	    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") int contactId,
	                                                         @RequestBody ContactDTO contactDTO) {
	        Contact contactData = addressbookservice.updateContact(contactId, contactDTO);
	        ResponseDTO response = new ResponseDTO("Updated contact data for", contactData);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @DeleteMapping("/delete/{contactId}")
	    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
	        addressbookservice.deleteContact(contactId);

	        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }
	
	
}
