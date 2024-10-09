package com.school.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.contact.entity.Contact;
import com.school.contact.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactController {

	@Autowired
	private ContactService contactService;

	//get All the contacts from database...
	@GetMapping("/")
	public List<Contact> getAllContact() {
		log.error("Contact controller called...");
		return contactService.findAllContacts();
	}

	@PostMapping("/addContact")
	public Contact createContact(@Valid @RequestBody Contact contact) {
		System.out.println(contact);
		return contactService.createContact(contact);
	}

}
