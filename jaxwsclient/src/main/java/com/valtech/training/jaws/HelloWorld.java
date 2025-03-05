package com.valtech.training.jaws;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	String hello(String name);

}