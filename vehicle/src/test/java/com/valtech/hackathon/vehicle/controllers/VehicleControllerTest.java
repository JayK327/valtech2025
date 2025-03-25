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

import com.valtech.hackathon.vehicle.vos.VehicleVO;

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
				
				restTemplate.postForObject(url, new VehicleVO(0, "Toyota", "Corolla", 15.5, 2000000L, "Sedan"), VehicleVO.class);
			    restTemplate.postForObject(url, new VehicleVO(0, "Tesla", "X", 12.5, 2300000L, "ybrid"), VehicleVO.class);
			      
			}
		}
}
