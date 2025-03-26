package com.valtech.training.quiz.entities;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Quiz {

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq",sequenceName = "quizseq",allocationSize = 1)
	private long id;
	private String quizTitle;
	
	@ElementCollection
	private List<Integer> questionIds;
	
	
	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Quiz(long id, String quizTitle, List<Integer> questionIds) {
		this.id = id;
		this.quizTitle = quizTitle;
		this.questionIds = questionIds;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}


	@Override
	public String toString() {
		return "Quiz [id=" + id + ", quizTitle=" + quizTitle + ", questionIds=" + questionIds + "]";
	}
	
	
	
	
}
