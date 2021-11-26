package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;

import lombok.Data;

@Data
public class Contact {
	 private int contactId;
	 private String firstName;
	 private String lastName;
	 private String address;
	 private String state;
	 private String city;
	 private String zip;
	 private String phone;
	 
	 
	public Contact(int contactId, String firstName, String lastName, String address, String state, String city,
			String zip, String phone) {
		super();
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
	}
	public Contact(int contactId, ContactDTO contactDTO) {
		super();
		this.contactId = contactId;
		this.firstName = contactDTO.getFirstName();
        this.lastName = contactDTO.getLastName();
        this.address = contactDTO.getAddress();
        this.city = contactDTO.getCity();
        this.state = contactDTO.getState();
        this.zip = contactDTO.getZip();
        this.phone = contactDTO.getPhone();
	}   
	
}
