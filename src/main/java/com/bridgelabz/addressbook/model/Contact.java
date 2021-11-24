package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.ContactDTO;

public class Contact {
	 private int contactId;
	 private String firstName;
	 private String lastName;
	 private String address;
	 private String state;
	 private String city;
	 private String zip;
	 private String phone;
	 
	 
	public Contact(int contactId, ContactDTO contactDTO) {
		super();
		this.contactId = contactId;
		this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.state = contactDTO.state;
        this.city = contactDTO.city;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", state=" + state + ", city=" + city + ", zip=" + zip + ", phone=" + phone + "]";
	}
    
	
}
