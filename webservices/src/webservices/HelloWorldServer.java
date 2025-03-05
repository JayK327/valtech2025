package webservices;

import org.apache.cxf.frontend.ServerFactoryBean;

public class HelloWorldServer {
	public static void main(String[] args) {
		ServerFactoryBean server=new ServerFactoryBean();
		server.setAddress("http://localhost:7777/HelloWorld");
		server.setServiceBean(new HelloWorldImpl());
		server.setServiceClass(HelloWorld.class);
		server.create();
		System.out.println("Server Running....");
	}
}
