package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
//	@OneToOne(cascade = CascadeType.ALL)// Cascade saves Answer when Question is saved
//	@JoinColumn(name="a_id")
//	private Answer answer;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Question(int questionId, String question, Answer answer) {
//		super();
//		this.questionId = questionId;
//		this.question = question;
//		this.answer = answer;
//	}
	
	public int getQuestionId() {
		return questionId;
	}
	public Question(int questionId, String question, List<Answer> answers) {
	super();
	this.questionId = questionId;
	this.question = question;
	this.answers = answers;
}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
//	public Answer getAnswer() {
//		return answer;
//	}
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
}
