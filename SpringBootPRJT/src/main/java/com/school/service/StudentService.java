package com.school.service;

import java.util.List;

import com.school.entity.StudentDetails;
import com.school.entity.Subject;
import com.school.exception.StudentNotFoundException;

public interface StudentService {

	// Method to create a new student
	StudentDetails createStudent(StudentDetails student);

	// Method to delete a student by ID
	void deleteStudentDetails(int studentId) throws StudentNotFoundException;

	// Method to update student details
	StudentDetails updateStudentDetails(StudentDetails updateDetails) throws StudentNotFoundException;

	// Method to add courses to a student
	StudentDetails addCoursesToStudent(int studentId, List<Subject> subjects) throws StudentNotFoundException;
	
	//Method to get all student details
	List<StudentDetails> getAllStudentDetails();
	
	//Method to get student details by id
		StudentDetails getStudentDetailsById(int id) throws StudentNotFoundException;
}
