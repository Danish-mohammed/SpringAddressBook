package com.bridgelabz.addressbook.dto;

import lombok.Data;

public @Data class ContactDTO {

	private String firstName;
    private String lastName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;
    
	public ContactDTO(String firstName, String lastName, String address,  String city,String state, String zip,
			String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "ContactDTO [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", state="
				+ state + ", city=" + city + ", zip=" + zip + ", phone=" + phone + "]";
	}
    
    
}
