package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Answer answer=new Answer();
        answer.setAnswerId(122);
        answer.setAnswer("Java is a programming language");
        
        
        Question q1=new Question();
        q1.setQuestionId(1);
        q1.setQuestion("What is java?");  
//        q1.setAnswer(answer);
        
        answer.setQuestion(q1);
        
        Answer a2=new Answer();
        a2.setAnswerId(237);
        a2.setAnswer("Java is platform independent");
        a2.setQuestion(q1);
        
        Answer a1=new Answer();
        a1.setAnswerId(437);
        a1.setAnswer("Java has different type of framework");
        a2.setQuestion(q1);
        
        List<Answer> list=new ArrayList<Answer>();
        list.add(answer);
        list.add(a1);
        list.add(a2);
        q1.setAnswers(list);
        
        
//        Question q2=new Question();
//        q2.setQuestionId(2);
//        q2.setQuestion("What is collection framework?"); 
//        q2.setAnswer(a2);
//          a2.setAnswer("API to work with object in java");

//        a2.setQuestion(q2); 
;
        
        
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(q1);
//        s.save(q2);
        
        s.save(answer);
        s.save(a1);
        s.save(a2);
        tx.commit();
        
        Question q=(Question)s.get(Question.class, 1);
        System.out.println(q.getQuestion());
        for(Answer a:q.getAnswers()) {
        	System.out.println(a.getAnswer());
        }
        
        //fetch data
//        Question sameQ2=(Question)s.get(Question.class,2);
//        System.out.println(sameQ2.getQuestion());
//        System.out.println(sameQ2.getAnswer().getAnswer());
        s.close();
        factory.close();
        
	}

}
