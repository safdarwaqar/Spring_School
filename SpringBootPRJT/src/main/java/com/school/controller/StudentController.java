package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.StudentDetails;
import com.school.entity.Subject;
import com.school.exception.StudentNotFoundException;
import com.school.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public List<StudentDetails> getAllStudentDetails() {
		return studentService.getAllStudentDetails();
	}
	
	@GetMapping("/{id}")
	public StudentDetails getStudentDetailsById(@PathVariable int id) throws StudentNotFoundException {
		return studentService.getStudentDetailsById(id);
	}

	// Endpoint to create a new student
	@PostMapping("/create")
	public ResponseEntity<StudentDetails> createStudent(@Valid @RequestBody StudentDetails student) {
		System.out.println("Accepted Request");
		StudentDetails createdStudent = studentService.createStudent(student);
		return ResponseEntity.ok(createdStudent);
	}

	// Endpoint to update student details
	@PutMapping
	public ResponseEntity<StudentDetails> updateStudentDetails(@Valid @RequestBody StudentDetails studentDetails)
			throws StudentNotFoundException {
		StudentDetails updatedStudent = studentService.updateStudentDetails(studentDetails);
		return ResponseEntity.ok(updatedStudent);
	}

	// Endpoint to delete a student by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) throws StudentNotFoundException {
		studentService.deleteStudentDetails(id);
		return ResponseEntity.noContent().build();
	}

	// Endpoint to add courses to a student
	@PostMapping("/{id}/courses")
	public ResponseEntity<StudentDetails> addCoursesToStudent(@PathVariable int id,
			@Valid @RequestBody List<Subject> subjects) throws StudentNotFoundException {
		StudentDetails updatedStudent = studentService.addCoursesToStudent(id, subjects);
		return ResponseEntity.ok(updatedStudent);
	}
}