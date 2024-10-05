package com.school.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.exam.entity.Examination;
import com.school.exam.repository.ExaminationRepository;
import com.school.exam.service.ExaminationService;

@RestController
@RequestMapping("/api/examinations")
public class ExaminationController {

    private final ExaminationService examinationService;
    
    //Autowiring for auto object creation...
    @Autowired
    private ExaminationRepository repo;

    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    // Get all examinations
    @GetMapping("/")
    public List<Examination> getAllExaminations() {
        return examinationService.getAllExaminations();
    }

    // Get an examination by ID
    @GetMapping("/{id}")
    public ResponseEntity<Examination> getExaminationById(@PathVariable Long id) {
        return examinationService.getExaminationById(id)
                .map(examination -> new ResponseEntity<>(examination, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new examination
    @PostMapping
    public ResponseEntity<List<Examination>> createExamination(@RequestBody List<Examination> examination) {
    	List<Examination> saveAll = repo.saveAll(examination);
    	examination.forEach(x-> repo.save(x));
    	
    	//return null;
       // Examination createdExamination = examinationService.createExamination(examination);
        return new ResponseEntity<>(saveAll, HttpStatus.CREATED);
    }

    // Update an existing examination
    @PutMapping("/{id}")
    public ResponseEntity<Examination> updateExamination(@PathVariable Long id, @RequestBody Examination examination) {
        examination.setId(id);
        Examination updatedExamination = examinationService.createExamination(examination);
        return new ResponseEntity<>(updatedExamination, HttpStatus.OK);
    }

    // Delete an examination by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamination(@PathVariable Long id) {
        examinationService.deleteExamination(id);
        return ResponseEntity.noContent().build();
    }
}
