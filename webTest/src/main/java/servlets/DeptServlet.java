//package servlets;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//
//@WebServlet(urlPatterns = "/depts")
//
//
//public class DeptServlet extends HttpServlet {
//	
//	private DeptDAO deptDAO;
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		deptDAO= new DeptDAOImpll();
//		deptDAO.save(new Dept(1,"HR","Blr"));
//		deptDAO.save(new Dept(2,"HR","Ahm"));
//		deptDAO.save(new Dept(3,"Dev","Blr"));
//		deptDAO.save(new Dept(4,"Dev","Ahm"));
//	}
//
//	
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String operation=req.getParameter("operation");
//		HttpSession session=req.getSession();
//		Dept current=(Dept) session.getAttribute("current");
//		if(current == null) {
//			current=deptDAO.first();
//		} else {
//			if("First".equals(operation)) {
//				current = deptDAO.first();
//			} else if("Last".equals(operation)) {
//				current = deptDAO.last();
//			} else if("Previous".equals(operation)) {
//				current = deptDAO.previous(current.getId());
//			} else {
//				current = deptDAO.next(current.getId());
//			}
//		}
////		System.out.println(current);
//		session.setAttribute("current", current);
//		//Expression in JSP can work with objects in session also...
//		req.setAttribute("dept", current);
//		
//		
//		Cookie [] cookies=req.getCookies();
//		for (int i = 0; i < cookies.length; i++) {
//			System.out.println(cookies[i].getName() + " " +cookies[i].getValue());
//		}
//		resp.addCookie(new Cookie("operation",operation));
//		req.getRequestDispatcher("depts.jsp").forward(req, resp);
//	}
//
//
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("dept", deptDAO.first());
//		HttpSession session=req.getSession();
//		session.setAttribute("current",deptDAO.first());
//		req.getRequestDispatcher("depts.jsp").forward(req, resp);
//		
//	}
//}
package servlets;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import servlets.DeptDAO;
import servlets.DeptDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns="/depts")
public class DeptServlet extends HttpServlet {
	private DeptDAO deptdao;	
	private EmployeeDAOImpl empdao;
	private DeptDAOImpl dept;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		ServletContext sce=config.getServletContext();
//		deptdao=(DepDAOImpl)sce.getAttribute("Department");
//		empdao=(EmployeeDAOImpl)sce.getAttribute("Employee");
		deptdao=(DeptDAOImpl)config.getServletContext().getAttribute("dept");    
		empdao=(EmployeeDAOImpl)config.getServletContext().getAttribute("emp");
	    if (deptdao == null) {
	        throw new ServletException("DeptDAO not initialized properly!");
	    }

	    if (deptdao.first() == null) {
	        System.out.println("Warning: No departments found in the database.");
	    }

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		String operation=req.getParameter("operation");
		HttpSession session=req.getSession();
		Dept current=(Dept) session.getAttribute("current");
		System.out.println("Printing The Current Object"+current);
		if(current==null) {
			
			current=deptdao.first();
			System.out.println(current);
		}
		else {
			if("First".equals(operation)) {
				current=deptdao.get(1);
			}
			else if("Last".equals(operation)) {
				current= deptdao.last();
			}
			else if("Previous".equals(operation)) {
				current=deptdao.previous(current.getId());
			}
			else {
				System.out.println("In the Next Method");
				System.out.println("Next");
				current=deptdao.next(current.getId());
			}
		}

		
		session.setAttribute("current", current);
		req.setAttribute("emps", empdao.getEmployeeByDepartment(current.getId()));
		req.setAttribute("dept", current);

		Cookie [] cookies=req.getCookies();
		for(int i=0;i<cookies.length;i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
		
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("depts.jsp").forward(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setAttribute("dept",deptdao.first());
		HttpSession session=req.getSession();
		System.out.println("IN THE DEPT SERVLET"+session.getAttribute("current"));
		if((Boolean)req.getAttribute("flag")!=null && (Boolean)req.getAttribute("flag")==true) {
			System.out.println("In the if method");
			System.out.println("in the if"+session.getAttribute("current"));	
			req.setAttribute("dept",session.getAttribute("current"));
			System.out.println(req.getAttribute("emps"));
			req.getRequestDispatcher("/depts.jsp").forward(req, resp);
			return;
//			session.setAttribute("current",session.getAttribute("current"));
//			System.out.println(req.getAttribute("emps"));
		}
		else
		{
			System.out.println("In the Else Method");
			System.out.println(deptdao.first());
		req.setAttribute("emps",empdao.getEmployeeByDepartment(deptdao.first().getId()));
		session.setAttribute("current",deptdao.first());
		System.out.println("Session"+session.getAttribute("current"));
		}
//		session.setAttribute("current",deptdao.first());
		System.out.println(empdao.getEmployeeByDepartment(deptdao.first().getId()));

		req.getRequestDispatcher("/depts.jsp").forward(req, resp);

	}
}

