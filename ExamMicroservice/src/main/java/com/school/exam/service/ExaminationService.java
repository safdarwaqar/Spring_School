package com.school.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.school.exam.entity.Examination;

@Service
public interface ExaminationService {

	List<Examination> getAllExaminations();

	public Optional<Examination> getExaminationById(Long id);

	public Examination createExamination(Examination examination);

	public void deleteExamination(Long id);
}
