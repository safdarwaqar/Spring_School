package com.school.entity;

import java.util.List;

public class Questions {

	private Long id;

	private String title;
	private String description;

	private List<String> questions;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Examination [id=" + id + ", title=" + title + ", description=" + description + ", questions="
				+ questions + "]";
	}

}
