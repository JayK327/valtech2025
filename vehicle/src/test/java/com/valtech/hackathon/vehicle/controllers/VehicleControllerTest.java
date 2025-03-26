package com.valtech.hackathon.vehicle.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.hackathon.vehicle.dtos.VehicleDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class VehicleControllerTest {
	
		@LocalServerPort
		private Integer port;
		
		@Autowired
		private TestRestTemplate restTemplate;
		
		@Test
		void test() {
			String url="http://localhost:"+port+"/api/v1/vehicles/";
			List vehicles=restTemplate.getForObject(url, List.class);
			if(vehicles.size()==0) {
				
				restTemplate.postForObject(url, new VehicleDTO(0, "Altroz", "Tata", 20, 820000L, "Hatchback"), VehicleDTO.class);
			    restTemplate.postForObject(url, new VehicleDTO(0, "Baleno", "MarutiSuzuki", 22, 780000L, "Hatchback"), VehicleDTO.class);
			    restTemplate.postForObject(url, new VehicleDTO(0, "Punch", "Tata", 17, 700000L, "MUV"), VehicleDTO.class);
			    restTemplate.postForObject(url, new VehicleDTO(0, "I20", "Hyundai", 18, 900000L, "Hatchback"), VehicleDTO.class);
			    restTemplate.postForObject(url, new VehicleDTO(0, "Breeza", "MarutiSuzuki", 18, 1150000L, "SUV"), VehicleDTO.class);
			      
			}
		}
}