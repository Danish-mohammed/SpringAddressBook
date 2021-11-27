package com.bridgelabz.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.ContactDTO;

import lombok.Data;

@Entity
@Table(name = "addressbook_db")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Contact_Id")
    private int contactId;
    @Column(name = "First_Name")
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
		this.updateContact(contactDTO);
	}
	
	private void updateContact(ContactDTO contactDTO) {
		this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;		
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", state=" + state + ", city=" + city + ", zip=" + zip + ", phone=" + phone + "]";
	}
	
	
}
