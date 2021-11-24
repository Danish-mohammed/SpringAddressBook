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

import com.bridgelabz.addressbook.model.Contact;

@RestController
@RequestMapping("/addressbookhome")
public class AddressBookController {
	@RequestMapping(value={"/","","/get"})
	public String WelcomeUser() {
		return "Welcome to address book home";
	}
	
	@GetMapping("/get")
	public ResponseEntity<String> getAddressBookData(){
		return new ResponseEntity<String>("Successfull got the data",HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<String> WelcomeuserbyID(@PathVariable("id") String id) {
		return new ResponseEntity<String>("Welcome, User " + id,HttpStatus.OK);
	}
	
	 @PostMapping("/create")
	    public ResponseEntity<String> createContact(@RequestBody Contact contact) {
	        return new ResponseEntity<String>("Added " + contact + " to list",HttpStatus.OK);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateContact(@PathVariable("id") int id,@RequestBody Contact contact) {
	        return new ResponseEntity<String>("Updated address book of id : " + id +" "+contact,HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteContact(@PathVariable String id) {
	        return new ResponseEntity<String>("Deleted contact " + id,HttpStatus.OK);
	    }
	
	
}
