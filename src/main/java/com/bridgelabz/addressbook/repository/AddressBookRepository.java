package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbook.model.Contact;

public interface AddressBookRepository extends JpaRepository<Contact, Integer> {

}
