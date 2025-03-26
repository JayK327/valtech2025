package com.valtech.training.quiz.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quiz.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Long> {

}
