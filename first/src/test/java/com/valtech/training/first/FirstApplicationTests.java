package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.AuthorRepo;
import com.valtech.training.first.services.BookStoreService;
import com.valtech.training.first.services.QuestionService;

@Transactional(propagation = Propagation.REQUIRED)
@SpringBootTest
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest si;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private BookStoreService bookStoreService;

	@Test
	void testArithmetic() {
		assertEquals(10,arithmetic.add(4,6));
	}

	@Test
	void testSimpleInterest() {
		assertEquals(200,si.compute(200, 5, 20));
	}
	@Test
	@Rollback()
	void questionService() {
		initData();
		assertEquals(6,questionService.countByTopic("GK"));
		assertEquals(6,questionService.countByTopic("Java"));
		assertEquals(2,questionService.countByTopicAndQuestionTextContaining("Java","Exceptions"));
		assertEquals(3,questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		assertEquals(5,questionService.findAllByTopic("GK",0,5).size());
		assertEquals(1,questionService.findAllByTopic("GK",1,5).size());


	}
	
	@Test
	void testBookStore() {
		assertEquals(3,bookStoreService.countAllPublisher());
		assertEquals(6,bookStoreService.countAllBook());
		assertEquals(6,bookStoreService.countAllAuthor());
		assertEquals(5,bookStoreService.getBooksByYearBetween(2000,2006).size());
//		assertEquals(3,bookStoreService.getBooksByPriceGreaterThan(100).size());
//		assertEquals(2,bookStoreService.findAllPriceByAuthorsId(1).size());
//		System.err.println(bookStoreService.findAllPriceByAuthorsId(1));
//		System.err.println(bookStoreService.getBookInfoByAuthor(2));		
	}
	
	
//	@BeforeEach
	void initData() {
//		long count=questionService.count();
//		if(count !=0) return;
		Question q=questionService.saveQuestion(new Question("What color of sky is?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What color of Mars is?","Red","Blue","Green","White","Red","GK"));
		questionService.saveQuestion(new Question("What color of Moon is?","Red","Blue","Green","White","White","GK"));
		questionService.saveQuestion(new Question("What color of Venus is?","Red","Blue","Green","White","White","GK"));
		questionService.saveQuestion(new Question("What color of Saturn is?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What color of Jupiter is?","Red","Blue","Green","Yellow","Yellow","GK"));
		questionService.saveQuestion(new Question("What is the super class of Exceptions?","Object","Error","Exception","Throwable","Throwable","Java"));
		questionService.saveQuestion(new Question("What class is used to create Dynamic Strings?","String","DynamicString","StringBuilder","Builder","StringBuilder","Java"));
		questionService.saveQuestion(new Question("How many Methods are there in marker Interface?","None","One","Two","MoreThanTwo","None","Java"));
		questionService.saveQuestion(new Question("How many Methods are there in functional Interface?","None","One","Two","MoreThanTwo","One","Java"));
		questionService.saveQuestion(new Question("Can an Interface have private method ?","Yes","No","May be","No methods can be there in interface","Yes","Java"));
		questionService.saveQuestion(new Question("What subclass of Exceptions is not checked by the compiler?","RuntimeException","Error","Exception","None","RuntimeException","Java"));


		
	}
	
	
}
