package com.bridgelabz.addressbook.dto;

import lombok.Data;
import javax.validation.constraints.*;


public @Data class ContactDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Address book is Invalid!!! ")
	@NotEmpty(message = "first name cannot be null")
	public String firstName;

	@Pattern(regexp = "^[A-Z]{1,}[a-zA-z\\s]{2,}$", message = "Address book is Invalid!!! ")
	@NotEmpty(message = "first name cannot be null")
	public String lastName;
	@Pattern(regexp = "^[A-Za-z,.0-9]{3,}$", message = "Address is Invalid!!! ")
	@NotEmpty(message = "Address cannot be null")
	public String address;
	public String state;
	public String city;
	@Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$")
	public String zip;
	@Pattern(regexp = "^^[0-9]{2}?[\\s,-]{0,1}[7-9]{1}[0-9]{9}$")
	public String phone;

	public ContactDTO(String firstName, String lastName, String address, String city, String state, String zip,
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
