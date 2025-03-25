package com.valtech.training.question.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.question.vos.QuestionVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuestionControllerTests {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void addQuestions() {
		List questions=restTemplate.getForObject("http://localhost:"+port+"/api/v1/questions/", List.class);
		if(questions.size()==0){
			
			System.out.println("-----------Add Data in database---------");
			
			
			QuestionVO question1 = restTemplate.postForObject(
				    "http://localhost:" + port + "/api/v1/questions/",
				    new QuestionVO(0, "What is the sum of 25 and 37?", "62", "52", "72", "82", "62", "Easy", "Mathematics"),
				    QuestionVO.class
				);

				QuestionVO question2 = restTemplate.postForObject(
				    "http://localhost:" + port + "/api/v1/questions/",
				    new QuestionVO(0, "What is the square root of 144?", "12", "14", "10", "16", "12", "Medium", "Mathematics"),
				    QuestionVO.class
				);

				QuestionVO question3 = restTemplate.postForObject(
				    "http://localhost:" + port + "/api/v1/questions/",
				    new QuestionVO(0, "What is the result of 8 * 7?", "56", "48", "64", "72", "56", "Easy", "Mathematics"),
				    QuestionVO.class
				);

				QuestionVO question4 = restTemplate.postForObject(
				    "http://localhost:" + port + "/api/v1/questions/",
				    new QuestionVO(0, "What is the value of pi approximately?", "3.14", "3.00", "3.18", "3.10", "3.14", "Medium", "Mathematics"),
				    QuestionVO.class
				);

				QuestionVO question5 = restTemplate.postForObject(
				    "http://localhost:" + port + "/api/v1/questions/",
				    new QuestionVO(0, "What is the derivative of x^2?", "2x", "x", "2", "x^2", "2x", "Hard", "Mathematics"),
				    QuestionVO.class
				);

				QuestionVO question6 = restTemplate.postForObject(
				    "http://localhost:" + port + "/api/v1/questions/",
				    new QuestionVO(0, "What is 2^5?", "32", "64", "16", "8", "32", "Easy", "Mathematics"),
				    QuestionVO.class
				);
			
		}
		
	}

}
