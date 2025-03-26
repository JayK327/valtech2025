package com.valtech.training.result.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.valtech.training.result.entities.QuizResult;

import java.util.List;

@Repository
public interface ResultRepo extends JpaRepository<QuizResult, Long> {
	
    List<QuizResult> findByUserName(String userName);
    
    List<QuizResult> findByQuizId(Long quizId);
}
