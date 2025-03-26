package com.valtech.training.restapis.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class OwnerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Test
	void test() throws Exception {
		//perform() method is used to simulate HTTP requests (in this case, a GET request).
		ResultActions result=mockMvc.perform(get("/api/v1/owners/{id}",1));
		result.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.name").value("Rohan"));
	}

}
/*
 * MockMvc is used to simulate HTTP requests to your Spring MVC
 *  controllers without needing to actually start a server.
 *   This allows you to test controllers in a mock environment.
 *    It provides a fluent API to perform actions like GET, POST,
 *     etc., on your endpoints and validate the responses
 */