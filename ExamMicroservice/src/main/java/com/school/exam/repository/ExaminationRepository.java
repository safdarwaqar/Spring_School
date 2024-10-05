package com.school.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.exam.entity.Examination;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {
}
