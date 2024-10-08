package com.school.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.school.entity.Questions;

//@FeignClient(url = "http://localhost:8081/api/examinations/", value = "Examination-Client")

@FeignClient(name = "exam-microservice")
public interface ExaminationClient {

	@GetMapping("api/examinations/")
	public List<Questions> getAllExaminations();

	// Get an examination by ID
	@GetMapping("/{id}")
	public ResponseEntity<Questions> getExaminationById(@PathVariable Long id);

	// Create a new examination
	@PostMapping
	public ResponseEntity<List<Questions>> createExamination(@RequestBody List<Questions> examination);

	// Update an existing examination
	@PutMapping("/{id}")
	public ResponseEntity<Questions> updateExamination(@PathVariable Long id, @RequestBody Questions examination);

	// Delete an examination by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExamination(@PathVariable Long id);

}
