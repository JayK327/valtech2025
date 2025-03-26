package com.valtech.training.loan.client.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loan.webservices.LoanServiceWS;

@Configuration
public class LoanClientConfig {

    @Bean
    public LoanServiceWS createLoanService() {
        JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
        proxy.setServiceClass(LoanServiceWS.class);
        proxy.setServiceName(new QName("http://webservices.loan.training.valtech.com/", "LoanServiceImplWSService"));
        proxy.setAddress("http://localhost:8080/services/loanService");
        return proxy.create(LoanServiceWS.class);
    }
}
