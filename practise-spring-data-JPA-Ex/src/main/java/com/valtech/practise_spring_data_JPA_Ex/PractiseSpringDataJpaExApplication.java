package com.valtech.practise_spring_data_JPA_Ex;

import java.util.Optional;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.valtech.practise_spring_data_JPA_Ex.model.Student;
import com.valtech.practise_spring_data_JPA_Ex.repo.StudentRepo;



@SpringBootApplication
public class PractiseSpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(PractiseSpringDataJpaExApplication.class, args);
//		Student s1= context.getBean(Student.class);
//		s1.setMarks(86);
//		s1.setName("Raj");
//		s1.setRollno(5);
//		
//		Student s2= context.getBean(Student.class);
//		s2.setMarks(68);
//		s2.setName("Rahul");
//		s2.setRollno(4);
//		
		Student s3= context.getBean(Student.class);
//		s3.setMarks(74);
//		s3.setName("Ravi");
//		s3.setRollno(3);
//		
		StudentRepo repo=context.getBean(StudentRepo.class);
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);
		System.out.println(repo.findAll());
		System.out.println(repo.findById(4));
		Optional<Student> s=repo.findById(21);
		System.out.println(s.orElse(new Student()));
		System.out.println(repo.findByName("Ravi"));
		System.out.println(repo.findByMarksGreaterThan(72));

		s3.setMarks(74);
		s3.setName("Ravi");
		s3.setRollno(3);
		repo.save(s3);
		//repo.delete(s3);
	}

}
