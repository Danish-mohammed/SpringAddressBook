package com.bridgelabz.addressbook.controller;

import java.util.List;

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

@RestController
@RequestMapping("/addressbookhome")
public class AddressBookController {
	@RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {

        Contact contact = new Contact(1,
                new ContactDTO("Mohammed", "Atif", "RT Nagar", "Karnataka", "Bengaluru", "560039", "9631234568"));
        ResponseDTO response = new ResponseDTO("Get call success", contact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

	
	 @GetMapping("/get/{contactId}")
	    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("contactId") int contactId) {
	        Contact contact = new Contact(contactId,
	                new ContactDTO("Sachin", "Tendulkar", "LalGanj", "Mumbai", "Maharashtra", "560000", "9631236547"));
	        ResponseDTO response = new ResponseDTO("Get call success for id", contact);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PostMapping("/create")
	    public ResponseEntity<ResponseDTO> addContactData(@RequestBody ContactDTO contactDTO) {
	        Contact contact = new Contact(1, contactDTO);
	        ResponseDTO response = new ResponseDTO("Created contact data for", contact);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PutMapping("/update/{contactId}")
	    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("contactId") int contactId,
	                                                         @RequestBody ContactDTO contactDTO) {
	        Contact contact = new Contact(1, contactDTO);
	        ResponseDTO response = new ResponseDTO("Updated contact data for", contact);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @DeleteMapping("/delete/{contactId}")
	    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("contactId") int contactId) {
	        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + contactId);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }
	
	
}
