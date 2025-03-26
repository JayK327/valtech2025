package com.valtech.training.restapis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.restapis.vos.OwnerVO;

//tells Spring Boot to start the application with a real web server on a random port.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestapisApplicationTests {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;//used to perform HTTP requests to the application in the test.

	@Test   //Restapi convert java into json to send data on server 
	void getOwnerWithId() throws Exception {
		int id=1;
		String url= "http://localhost:" +port+"/api/v1/owners/"+id;
		OwnerVO owner=restTemplate.getForObject(url, OwnerVO.class);
	}

}
/*
 * This makes a GET request to the url (which is the API endpoint that fetches the owner by ID).
The getForObject() method returns the response body, which is automatically
 deserialized into an instance of the OwnerVO class.
OwnerVO.class specifies that the response should be mapped to an OwnerVO object.
 * 
 */