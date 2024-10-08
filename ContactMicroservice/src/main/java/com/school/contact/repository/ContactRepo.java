package com.school.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.contact.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}
