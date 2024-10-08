package com.school.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.entity.Contact;

import jakarta.validation.Valid;

@FeignClient (name = "CONTACT-MICROSERVICE")
public interface ContactServiceClient {
	
	@GetMapping("contact/")
	public List<Contact> getAllContact();

	@PostMapping("contact/addContact")
	public Contact createContact(@Valid @RequestBody Contact contact);


}
