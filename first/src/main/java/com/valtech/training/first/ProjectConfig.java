package com.valtech.training.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration    //this file is use to defines beans/dependencies
public class ProjectConfig {
	
////	@Bean   //All dependencies pass in constructor
//	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
//		return new SimpleInterestImpl(arithmetic);
//	}
	
//	@Bean    //2 ways either @Bean here or @Component in impl file
	public Arithmetic arithmetic() {
		return new ArithmeticImpl();
	}
	
}
