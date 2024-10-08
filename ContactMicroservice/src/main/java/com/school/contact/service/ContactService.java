package com.school.contact.service;

import java.util.List;

import com.school.contact.entity.Contact;

public interface ContactService {

	Contact createContact(Contact contact);

	Contact updateContact(Contact contact);

	void deleteContact(int id);

	Contact findContactById(int id);

	List<Contact> findAllContacts();

}
