package com.school.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.exam.controller.ExaminationController;
import com.school.exam.repository.ExaminationRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService {
	private final ExaminationRepository repository;

	public ExaminationServiceImpl(ExaminationRepository repository) {
		this.repository = repository;
	}

	public List<ExaminationController> getAllExaminations() {
		return repository.findAll();
	}

	public Optional<ExaminationController> getExaminationById(Long id) {
		return repository.findById(id);
	}

	public ExaminationController createExamination(ExaminationController examination) {
		return repository.save(examination);
	}

	public void deleteExamination(Long id) {
		repository.deleteById(id);
	}
}
