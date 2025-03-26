package com.valtech.training.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.entities.OptionsChoosen;
import com.valtech.training.quiz.entities.QuestionWrapper;
import java.util.List;

@Service
public class QuestionClient {

    private String QUESTION_SERVICE_URL = "http://localhost:9050/api/v1/questions";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Integer> getQuestionsForQuiz(String topic, long numOfQuestions) {
        String url = QUESTION_SERVICE_URL + "/generate?topicName=" + topic + "&numOfQuestions=" + numOfQuestions;
        return restTemplate.getForObject(url,List.class);
    }

    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        String url = QUESTION_SERVICE_URL + "/getQuestions";
        return restTemplate.postForObject(url, questionIds, List.class);
    }

    public int getScore(List<OptionsChoosen> responses) {
        String url = QUESTION_SERVICE_URL + "/getScore";
        return restTemplate.postForObject(url, responses, Integer.class);
    }
}

