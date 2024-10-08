package com.school.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Contact;
import com.school.entity.StudentDetails;
import com.school.entity.Subject;
import com.school.exception.StudentNotFoundException;
import com.school.repositoy.StudentDetailsRepository;
import com.school.service.client.ContactServiceClient;
import com.school.service.client.ExaminationClient;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	// Getting Examination details from Exam-Microservice
	@Autowired
	private ExaminationClient examinationClient;
	
	@Autowired
	private ContactServiceClient contactClient;

	@Override
	public StudentDetails createStudent(StudentDetails student) {
		Contact contactFromRequest = student.getContactClient();
		StudentDetails savedStudent = studentDetailsRepository.save(student);
		contactFromRequest.setStudentId(Long.valueOf(savedStudent.getId()));
		
		contactClient.createContact(savedStudent.getContactClient());
		return studentDetailsRepository.save(student);
	}

	@Override
	public void deleteStudentDetails(int studentId) throws StudentNotFoundException {
		studentDetailsRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(
				String.format("Student with id \'%s\' could not be found, Please check and try again..", studentId)));
		studentDetailsRepository.deleteById(studentId);
	}

	@Override
	public StudentDetails updateStudentDetails(StudentDetails updateDetails) throws StudentNotFoundException {
		StudentDetails existingStudent = studentDetailsRepository.findById(updateDetails.getId())
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + updateDetails.getId()));

		existingStudent.setName(updateDetails.getName());
		existingStudent.setEmail(updateDetails.getEmail());
		existingStudent.setPhone(updateDetails.getPhone());
		existingStudent.setAddress(updateDetails.getAddress());
		existingStudent.setSubjects(updateDetails.getSubjects());
		return studentDetailsRepository.save(existingStudent);

	}

	@Override
	public StudentDetails addCoursesToStudent(int studentId, List<Subject> subjects) throws StudentNotFoundException {

		StudentDetails existingStudent = studentDetailsRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));
		existingStudent.getSubjects().addAll(subjects);
		return studentDetailsRepository.save(existingStudent);

	}

	@Override
	public List<StudentDetails> getAllStudentDetails() {
		List<StudentDetails> updatedStudentDtls = studentDetailsRepository.findAll().stream().map(x -> {
			x.setQuestion(examinationClient.getAllExaminations());
			List<Contact> allContact = contactClient.getAllContact();
			Contact c = allContact.get(0);
			System.out.println(c);
			x.setContactClient(c);
			return x;
		}).collect(Collectors.toList());
		return updatedStudentDtls;
	}

	@Override
	public StudentDetails getStudentDetailsById(int id) throws StudentNotFoundException {

		StudentDetails studentDetails = studentDetailsRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));

		studentDetails.setQuestion(examinationClient.getAllExaminations());
		return studentDetails;
	}

}