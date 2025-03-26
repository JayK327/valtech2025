package com.valtech.training.quiz.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.vos.QuizResultVO;

import org.springframework.beans.factory.annotation.Value;


@Service
public class ResultClient {

    private final RestTemplate restTemplate = new RestTemplate();
    
    private final String RESULT_SERVICE_URL = "http://localhost:9070/api/v1/results";
    
    public QuizResultVO saveResult(Long quizId, String userName, int score) {
        String url = RESULT_SERVICE_URL + "/save?quizId=" + quizId + "&userName=" + userName + "&score=" + score;
        return restTemplate.postForObject(url, null, QuizResultVO.class);
    }
}
