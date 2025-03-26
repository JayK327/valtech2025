package com.valtech.training.loan.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loan.services.LoanService;

import com.valtech.training.loan.webservices.LoanServiceImplWS;

@Configuration
public class LoanConfig {
	
	@Autowired
	private Bus bus; 
	
	@Bean
	public Endpoint loanServiceEndpoint(LoanService loanService) {  
        EndpointImpl endpoint = new EndpointImpl(bus, new LoanServiceImplWS(loanService));
        endpoint.setAddress("/loanService"); 
        endpoint.publish();
        return endpoint;
    }
	
}
