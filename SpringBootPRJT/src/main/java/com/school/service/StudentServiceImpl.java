package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.StudentDetails;
import com.school.entity.Subject;
import com.school.exception.StudentNotFoundException;
import com.school.repositoy.StudentDetailsRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	@Override
	public StudentDetails createStudent(StudentDetails student) {
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
		// TODO Auto-generated method stub
		return studentDetailsRepository.findAll();
	}

	@Override
	public StudentDetails getStudentDetailsById(int id) throws StudentNotFoundException {
		return studentDetailsRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	}

}