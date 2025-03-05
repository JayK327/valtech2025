package com.valtech.training.restapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {
//	@RequestMapping(method=RequestMethod.GET,path="/hello")  
	 //----Both are alternate ways to map HTTP GET request.----
//	@GetMapping("/hello")         ///url : hello?name=John
//	public String hello(@RequestParam("name") String name) {
//		return "Hello "+name;
//	}
	@GetMapping("/hello/{name}")   // if the URL is /hello/John, the value "John" will be passed into the name parameter.
	public String hello(@PathVariable("name") String name ,@RequestParam("times") int times) {
		String res="";
		for (int i = 0; i < times; i++) {
			res+=name;
			
		}
		return "Hello "+res;
	}
}

/*@PathVariable("name") String name: 
 * This annotation binds the value of the {name} 
 * part of the URL to the name parameter in the method.
 */
/*@RequestParam("times") int times:
 * This annotation binds the times query parameter 
 * from the URL to the times parameter
 * Eg: /hello/John?times=3--> Hello JohnJohnJohn.
 */