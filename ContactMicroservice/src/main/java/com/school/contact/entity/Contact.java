package com.school.contact.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long studentId;

	@NotBlank(message = "First name is mandatory")
	@Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotBlank(message = "Last name is mandatory")
	@Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Email(message = "Email should be valid")
	@Size(max = 100, message = "Email must be less than 100 characters")
	@Column(name = "email", unique = true)
	private String email;

//	private StudenDetailsClient studentClient;

	@Pattern(regexp = "^\\+?[0-9. ()-]{7,}$", message = "Phone number should be valid")
	@Size(max = 15, message = "Phone number must be less than 15 characters")
	@Column(name = "phone")
	private String phone;

	@Size(max = 250, message = "Address must be less than 250 characters")
	@Column(name = "address")
	private String address;

	@NotNull(message = "Date of birth is mandatory")
	@Past(message = "Date of birth must be in the past")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "gender")
	private String gender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
