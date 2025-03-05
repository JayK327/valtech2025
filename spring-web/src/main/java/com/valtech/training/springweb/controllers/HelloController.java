package com.valtech.training.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.springweb.vos.LoginVO;


@Controller
public class HelloController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	public ModelAndView test() {
		ModelAndView view=new ModelAndView("login");
		view.addObject("message","Pls use login dialog");
		return view;
	}
	
	@PostMapping("/login")
	public String handleLoginForm(@ModelAttribute LoginVO login,Model model) {//this is from request parameter where as requestbody is from requestBody 
		if("scott".equals(login.getUsername()) && "tiger".equals(login.getPassword())) {
			model.addAttribute("login",login);
			return "dashboard";
		}
		model.addAttribute("message","Invalid Username Password");
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "HelloSpringWeb";  //name of the view(jsp page) 
	}
}
