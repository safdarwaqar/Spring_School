package com.school.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.exam.entity.Examination;
import com.school.exam.repository.ExaminationRepository;

@Service
public class ExaminationServiceImpl implements ExaminationService {
	private final ExaminationRepository repository;

	public ExaminationServiceImpl(ExaminationRepository repository) {
		this.repository = repository;
	}

	public List<Examination> getAllExaminations() {
		return repository.findAll();
	}

	public Optional<Examination> getExaminationById(Long id) {
		return repository.findById(id);
	}

	public Examination createExamination(Examination examination) {
		return repository.save(examination);
	}

	public void deleteExamination(Long id) {
		repository.deleteById(id);
	}
}
