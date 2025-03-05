package com.valtech.training.first.repos;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>{  //(entity class,primaryKEYclass)
	List<Question> findAllByTopic(String topic);
	List<Question> findAllByTopic(String topic,Pageable pageable);

	
	long countByTopic(String topic);

	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);
}
