package spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.Employee;
import spring.tx.Employee.Gender;
import spring.tx.EmployeeService;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class TxClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		EmployeeService es=ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new Employee(10,"Rahul",10,1000,Gender.MALE,10,10));
		es.getAll().forEach(e->System.out.println(e));
		ctx.close();
	}
}
