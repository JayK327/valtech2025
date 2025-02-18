package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("First piece of code that will be executed...");
		System.out.println("Loading....Config...done...");
		System.out.println("Creating database connection pools....");
		ServletContext application= sce.getServletContext();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Closing all database connection in the connection pools");
	}

}
