package com.school.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.exam.controller.ExaminationController;

@Service
public interface ExaminationService {

	List<ExaminationController> getAllExaminations();

	public Optional<ExaminationController> getExaminationById(Long id);

	public ExaminationController createExamination(ExaminationController examination);

	public void deleteExamination(Long id);
}
