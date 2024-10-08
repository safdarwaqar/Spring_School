package com.school.contact.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.contact.entity.Contact;
import com.school.contact.repository.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepo contactRepo;

	@Override
	public Contact createContact(Contact contact) {

		return contactRepo.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		Optional<Contact> optional = contactRepo.findById(contact.getId());
		if(optional.isPresent())
			contactRepo.save(contact);
		return contactRepo.save(contact);
	}

	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact findContactById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findAllContacts() {
		// TODO Auto-generated method stub
		return contactRepo.findAll();
	}

}
