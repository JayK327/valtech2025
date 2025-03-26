package com.valtech.PractiseSpringJDBCEx;

import java.applet.AppletContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.valtech.PractiseSpringJDBCEx.models.Student;
import com.valtech.PractiseSpringJDBCEx.services.StudentService;

@SpringBootApplication
public class PractiseSpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(PractiseSpringJdbcExApplication.class, args);
		Student s= context.getBean(Student.class);
		s.setMarks(86);
		s.setName("Raj");
		s.setRollno(5);
		
		
		StudentService service=context.getBean(StudentService.class);
		service.addStudent(s);
		
		List<Student> students=service.getStudents();
		System.out.println(students);
	}

}
