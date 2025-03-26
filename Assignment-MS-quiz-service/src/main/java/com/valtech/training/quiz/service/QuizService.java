package com.valtech.training.quiz.service;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.quiz.entities.OptionsChoosen;
import com.valtech.training.quiz.entities.QuestionWrapper;
import com.valtech.training.quiz.vos.QuizVO;


@SpringBootApplication
public interface QuizService {
	
	QuizVO createQuiz(String topic, int numOfQuestions, String quiztitle);
	
	List<QuestionWrapper> getQuizQuestions(Long quizId);
	
	int calculateResult(Long quizId, List<OptionsChoosen> responses,String userName);
	
	
}
