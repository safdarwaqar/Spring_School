package com.school.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Contact {
	
	private Long id;
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;
    private String gender;

}
