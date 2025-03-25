package com.valtech.training.question.services;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.entities.QuestionWrapper;
import com.valtech.training.question.entities.OptionsChoosen;
import com.valtech.training.question.vos.QuestionVO;

@SpringBootApplication
public interface QuestionService {
	QuestionVO saveQuestion(QuestionVO q);
	
	QuestionVO updateQuestion(QuestionVO q,long id );
	
	QuestionVO getQuestion(long id);
	
	List<QuestionVO> getAllQuestion();
	
	List<QuestionVO> getQuestionsByTopic(String topic);

	List<Long> getQuestionsForQuiz(String topicName, int numOfQuestions);

	List<QuestionWrapper> getQuestionsFromId(List<Long> questionIds);


	int getScore(List<OptionsChoosen> responses);
}
