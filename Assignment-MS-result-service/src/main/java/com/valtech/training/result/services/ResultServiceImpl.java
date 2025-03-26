package com.valtech.training.result.services;

import com.valtech.training.result.entities.QuizResult;
import com.valtech.training.result.repos.ResultRepo;
import com.valtech.training.result.vos.QuizResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepo resultRepo;
    
    @Override
    public QuizResultVO saveResult(Long quizId, String userName, int score) {
        return QuizResultVO.from(resultRepo.save(new QuizResult(quizId, userName, score)));
    }
    @Override
    public List<QuizResultVO> getResultsByUser(String userName) {
        return resultRepo.findByUserName(userName).stream().map(result -> QuizResultVO.from(result)).collect(Collectors.toList());
    }
    @Override
    public List<QuizResultVO> getResultsByQuiz(Long quizId) {
        return resultRepo.findByQuizId(quizId).stream().map(result -> QuizResultVO.from(result)).collect(Collectors.toList());
    }
}
