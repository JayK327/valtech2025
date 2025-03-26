package com.valtech.training.result.entities;

import jakarta.persistence.*;

@Entity
public class QuizResult {

    @Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "res_seq")
    @SequenceGenerator(name = "res_seq",sequenceName = "resseq",allocationSize = 1)
    private Long id;
    private Long quizId;
    private String userName;
    private int score;

    public QuizResult() {}

    public QuizResult(Long quizId, String userName, int score) {
        this.quizId = quizId;
        this.userName = userName;
        this.score = score;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

 
}

