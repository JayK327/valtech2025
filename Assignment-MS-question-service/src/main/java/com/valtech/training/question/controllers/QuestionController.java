package com.valtech.training.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.question.entities.QuestionWrapper;
import com.valtech.training.question.entities.OptionsChoosen;
import com.valtech.training.question.services.QuestionService;
import com.valtech.training.question.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestions(){
		return questionService.getAllQuestion();	
	}
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO questionVO) {
		return questionService.saveQuestion(questionVO);
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") long id) {
		return questionService.getQuestion(id);
	}
	
	@PutMapping("/{id}")
	public QuestionVO updateQuestion(@PathVariable("id") long id, @RequestBody QuestionVO questionVO) {
		return questionService.updateQuestion(questionVO, id);
	}
	
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionsByTopic(@PathVariable String topic) {
	    return questionService.getQuestionsByTopic(topic);
	}

    @GetMapping("/generate")
    public List<Long> getQuestionsForQuiz(@RequestParam String topicName, @RequestParam int numOfQuestions) {
        return questionService.getQuestionsForQuiz(topicName, numOfQuestions);
    }

    @PostMapping("/getQuestions")
    public List<QuestionWrapper> getQuestionsFromIds(@RequestBody List<Long> questionIds) {
        return questionService.getQuestionsFromId(questionIds);
    }


    @PostMapping("/getScore")
    public int getScore(@RequestBody List<OptionsChoosen> responses) {
        return questionService.getScore(responses);
    }

}
