package servlets;

import java.io.InputStream;
import java.util.Properties;

import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ConfigListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
	private EmployeeDAOImpl dao;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Properties pd=new Properties();
		ServletContext context=sce.getServletContext();
		try(InputStream input= ConfigListener.class.getClassLoader().getResourceAsStream("db.properties")){
			if(input==null) {
				System.out.println("Empty File");
				return;
			}
			pd.load(input);
			context.setAttribute("jdbc_url", pd.getProperty("jdbc_url"));
			context.setAttribute("jdbc_user", pd.getProperty("jdbc_user"));
			context.setAttribute("jdbc_password", pd.getProperty("jdbc_password"));
			context.setAttribute("jdbc_driver", pd.getProperty("jdbc_driver"));
			System.out.println(pd.getProperty("jdbc_driver"));
            dao=new EmployeeDAOImpl(context);
            context.setAttribute("emp", dao);
            
			
			
            DeptDAOImpl deptdao = new DeptDAOImpl(context);
            context.setAttribute("dept", deptdao);
			
			try {
				Class.forName((String)context.getAttribute("jdbc_driver"));
				System.out.println("PostgreSQL Driver loaded successfully.");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();

		}
		}


}
