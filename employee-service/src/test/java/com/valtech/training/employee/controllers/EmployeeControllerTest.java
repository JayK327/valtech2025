package com.valtech.training.employee.controllers;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.employee.vos.EmployeeVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate ;
	
	@Test
	void AddEmployees() {
		List emps=restTemplate.getForObject("http://localhost:"+port+"/api/v1/employees/", List.class);
		if(emps.size()==0) {
			System.out.println("Adding Employes...to db...");
			EmployeeVO manager=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/", new EmployeeVO(0, "abc", "382480484384", "abc@gmail.com", 0), EmployeeVO.class);
			EmployeeVO manager1=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/", new EmployeeVO(0, "def", "480484384", "a@gmail.com", manager.id()), EmployeeVO.class);
			EmployeeVO emp=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/", new EmployeeVO(0, "pqr", "2480484384", "b@gmail.com", manager1.id()), EmployeeVO.class);
			EmployeeVO emp1=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/", new EmployeeVO(0, "xyz", "9382480484384", "c@gmail.com", manager.id()), EmployeeVO.class);
			EmployeeVO emp2=restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/", new EmployeeVO(0, "jkl", "6640484384", "d@gmail.com", manager1.id()), EmployeeVO.class);

		}
	}

}
