package com.valtech.ServletEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")  //work when we use external tomcat 
//this mapping can also be done using web.xml file also
public class HelloServlet extends HttpServlet{
	//service is a method which get executed whenever we sends a request
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		System.out.println("In service");
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h2><b>Hello World</b></h2>");
	}
}
