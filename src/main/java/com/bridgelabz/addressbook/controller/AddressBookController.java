package com.bridgelabz.addressbook.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.Util.TokenUtil;
import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/addressbookhome")
@Slf4j
public class AddressBookController {
	
	@Autowired
    private IAddressBookService addressbookservice;
	
	@Autowired
    TokenUtil tokenUtil;
	
	@RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {

        List<Contact> contactData = addressbookservice.getContact();
        log.debug("Address Book DTO: " +contactData.toString());
        ResponseDTO response = new ResponseDTO("Get call success", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

	
	 @GetMapping("/get")
	    public ResponseEntity<ResponseDTO> getContactData(@RequestHeader String token) {
		 Contact contactData = addressbookservice.getContactById(token);
	        ResponseDTO response = new ResponseDTO("Get call success for id", contactData);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PostMapping("/create")
	    public ResponseEntity<ResponseDTO> createContactData(@Valid @RequestBody ContactDTO contactDTO) {
	        Contact contactData = addressbookservice.createContact(contactDTO);
	        log.debug("Address Book DTO: " +contactData.toString());
	        ResponseDTO response = new ResponseDTO("Created contact data for", tokenUtil.createToken(contactData.getContactId()));
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PutMapping("/update")
	    public ResponseEntity<ResponseDTO> updateContactData(@RequestHeader String token,
	                                                         @Valid @RequestBody ContactDTO contactDTO) {
	        Contact contactData = addressbookservice.updateContact(token, contactDTO);
	        log.debug("AddressBook Contact After Update " + contactData.toString());

	        ResponseDTO response = new ResponseDTO("Updated contact data for", tokenUtil.createToken(contactData.getContactId()));
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @DeleteMapping("/delete")
	    public ResponseEntity<ResponseDTO> deleteContactData(@RequestHeader String token) {
	        addressbookservice.deleteContact(token);

	        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + tokenUtil.decodeToken(token));
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/deleteall")
	    public ResponseEntity<ResponseDTO> deleteAllAddressBookData() {
	        String message = addressbookservice.deleteAllAddressBookData();
	        ResponseDTO respDTO = new ResponseDTO("Deleteall:", message);
	        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	    }


	    @GetMapping("/city/{city}")
	    public ResponseEntity<ResponseDTO> getContactByCity(@PathVariable String city) {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.getContactByCity(city);
	        ResponseDTO response = new ResponseDTO("Get Call Contact List By city is Successful", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }

	    @GetMapping("/firstname/{firstName}")
	    public ResponseEntity<ResponseDTO> getContactByFirstName(@PathVariable String firstName) {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.getContactByFirstName(firstName);
	        ResponseDTO response = new ResponseDTO("Get Call Contact List By first name is Successful", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }

	    @GetMapping("/lastname/{lastName}")
	    public ResponseEntity<ResponseDTO> getContactByLastName(@PathVariable String lastName) {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.getContactByLastName(lastName);
	        ResponseDTO response = new ResponseDTO("Get Call Contact List By last name is Successful", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }


	    @GetMapping("/zip/{zip}")
	    public ResponseEntity<ResponseDTO> getContactByZip(@PathVariable String zip) {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.getContactByPincode(zip);
	        ResponseDTO response = new ResponseDTO("Get Call Contact List By Pincode is Successful", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }


	    @GetMapping("/sortbyname")
	    public ResponseEntity<ResponseDTO> sortByName() {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.sortByName();
	        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By Name: ", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }

	    @GetMapping("/sortbycity")
	    public ResponseEntity<ResponseDTO> sortByCity() {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.sortByCity();
	        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By City: ", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }

	    @GetMapping("/sortbypincode")
	    public ResponseEntity<ResponseDTO> sortByPincode() {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.sortByPincode();
	        ResponseDTO response = new ResponseDTO("Get Call  is Successful Sort By PinCode: ", contactList);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }

	    @GetMapping("/readallcontactbytoken")
	    public ResponseEntity<ResponseDTO> readdata(@RequestHeader(name = "token") String token) throws AddressBookException {
	        List<Contact> contactList = null;
	        contactList = addressbookservice.getAllContacts(token);
	        if (contactList.size() > 0) {
	            ResponseDTO responseDTO = new ResponseDTO("all user Fetched successfully", contactList);
	            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	        } else {
	            throw new AddressBookException("No Data Found");
	        }

	    }

	    @GetMapping("/readdatabytoken")
	    public ResponseEntity<ResponseDTO> readupdatedata(@RequestHeader(name = "token") String token) throws AddressBookException {
	        Optional<Contact> readData = null;
	        readData = addressbookservice.getData(token);

	        ResponseDTO responseDTO = new ResponseDTO("Updated data", readData);
	        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	    }
	
}
