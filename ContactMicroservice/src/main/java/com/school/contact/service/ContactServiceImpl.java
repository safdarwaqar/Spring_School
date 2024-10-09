package com.school.contact.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.contact.entity.Contact;
import com.school.contact.repository.ContactRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepo contactRepo;
	
	private final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Override
	public Contact createContact(Contact contact) {

		return contactRepo.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact) {
		Optional<Contact> optional = contactRepo.findById(contact.getId());
		if (optional.isPresent())
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
		log.error("Service called ....safdar");
		logger.error("Called using Logger sAfdar...");
		return contactRepo.findAll();
	}

}
