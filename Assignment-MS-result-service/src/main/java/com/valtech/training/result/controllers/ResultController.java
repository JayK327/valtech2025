package com.valtech.training.result.controllers;

import com.valtech.training.result.services.ResultService;
import com.valtech.training.result.vos.QuizResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/save")
    public QuizResultVO saveResult(@RequestParam Long quizId,@RequestParam String userName,@RequestParam int score) {
        return resultService.saveResult(quizId, userName, score);
    }

    @GetMapping("/user/{userName}")
    public List<QuizResultVO> getResultsByUser(@PathVariable String userName) {
        return resultService.getResultsByUser(userName);
    }

    @GetMapping("/quiz/{quizId}")
    public List<QuizResultVO> getResultsByQuiz(@PathVariable Long quizId) {
        return resultService.getResultsByQuiz(quizId);
    }
}
