package com.valtech.PractiseSpringMVCDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller  //In backend it gets converted in servlet 
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home method called");
		return "index";//tomcat jasper control jsp to servlet
	}
	
	@RequestMapping("home1")
	public String home1() {
		System.out.println("Home1 method called");
		return "add";//tomcat jasper control jsp to servlet
	}
	
//	//Servlet way
//	@RequestMapping("add")
//	public String add(HttpServletRequest req,HttpSession session) {
//		int num1=Integer.parseInt(req.getParameter("num1"));
//		int num2=Integer.parseInt(req.getParameter("num2"));
//		int result=num1+num2;
//		System.out.println(result);
//		
//		session.setAttribute("result",result);
//		return "result.jsp";
//	}
	
//	@RequestMapping("add")
//	public String add(int num1,int num2 ,HttpSession session) {//variable name should match
//		//if variable name not match then parameter be like (@RequestParam("num1") int num,int num2, HttpSession session
//		int result=num1+num2;
//		System.out.println(result);
//		
//		session.setAttribute("result",result);
//		return "result.jsp";
//	}
	
//	//Use when we want to return data only but if we want 
//	//both view and data then modelandview is better.
//	@RequestMapping("add")
//	public String add(int num1,int num2 ,Model model) {
//		int result=num1+num2;
//		System.out.println(result);
//		
//		model.addAttribute("result",result);
//		return "result";
//		//in this case we are returning two things- model object and view 
//	}
//	
	@RequestMapping("add")
	public ModelAndView add(int num1,int num2 ,ModelAndView mv) {
		int result=num1+num2;
		System.out.println(result);
		
		mv.addObject("result",result);
		mv.setViewName("result");
		return mv;
		//in this case we are returning two things- model object and view 
	}
	@RequestMapping("home2")
	public String home2() {
		System.out.println("Home2 method called");
		return "addAlien";//tomcat jasper control jsp to servlet
	}
	
//	@RequestMapping("addAlien")
//	public ModelAndView addAlien(@RequestParam("aid")int aid, @RequestParam("aname") String  aname ,ModelAndView mv) {
//		Alien alien=new Alien();
//		alien.setAid(aid);
//		alien.setAname(aname);
//		System.out.println(alien);
//		
//		mv.addObject("alien",alien);
//		mv.setViewName("result1");
//		return mv;
//		//in this case we are returning two things- model object and view 
//	}
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("alien1") Alien alien) {
		return "result1";
		//No need to write @ModelAttribute its by default.
		//But if name of object is different then needed to write.
	}
	
	@ModelAttribute("course")
	public String courseName() {
		return "Java";
	}
	
	
	
	
}
