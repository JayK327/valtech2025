package com.valtech.training.result.services;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.result.vos.QuizResultVO;

@SpringBootApplication
public interface ResultService {
	QuizResultVO saveResult(Long quizId, String userName, int score);
	
	List<QuizResultVO> getResultsByUser(String userName);
	
	List<QuizResultVO> getResultsByQuiz(Long quizId);
}
