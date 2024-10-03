package com.school.entity;

import lombok.Data;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;
	private String city;
	private String state;
	private String zipCode;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	private StudentDetails studentDetails; // To establish bi-directional relationship
}
