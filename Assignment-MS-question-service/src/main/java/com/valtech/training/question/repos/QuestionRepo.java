package com.valtech.training.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.training.question.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
	
	List<Question> findByTopic(String topic);
	
	@Query(value = "SELECT * FROM question WHERE topic = :topic ORDER BY RANDOM() LIMIT :numOfQustions", nativeQuery = true)
	List<Long> findRandomQuestionsByTopic( String topic,  int numOfQustions);

}
