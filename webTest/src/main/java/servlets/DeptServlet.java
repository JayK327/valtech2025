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
	
	@Override
	public void init(ServletConfig config) throws ServletException {
//		ServletContext sce=config.getServletContext();
//		deptdao=(DepDAOImpl)sce.getAttribute("Department");
//		empdao=(EmployeeDAOImpl)sce.getAttribute("Employee");
//		ServletContext sce=(ServletContext) config.getServletContext().getAttribute("dept");
//		deptdao=new DeptDAOImpl(sce);
//		deptdao = (DeptDAOImpl) config.getServletContext().getAttribute("dept");
		ServletContext sc = config.getServletContext();
		deptdao=new DeptDAOImpl(sc);
		empdao=new EmployeeDAOImpl(sc);

	  
//		empdao=(EmployeeDAOImpl)config.getServletContext().getAttribute("emp");
//	    if (deptdao == null) {
//	    	System.out.println("----------------------------");
//	        throw new ServletException("DeptDAO not initialized properly!");
//	    }

//	    if (deptdao.first() == null) {
//	        System.out.println("Warning: No departments found in the database.");
//	    }

	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stubs
//		String operation=req.getParameter("operation");
//		HttpSession session=req.getSession();
//		Dept current=(Dept) session.getAttribute("current");
//		if(current==null) {
//			
//			current=(Dept)deptdao.first();
//			System.out.println(current);
//		}
//		else {
//			if("First".equals(operation)) {
//				current=deptdao.first();
//			}
//			else if("Last".equals(operation)) {
//				current= deptdao.last();
//			}
//			else if("Previous".equals(operation)) {
//				current=deptdao.previous(current.getId());
//			}
//			else {
//				System.out.println("In the Next Method");
//				System.out.println("Next");
//				current=deptdao.next(current.getId());
//			}
//		}
//
//		
//		session.setAttribute("current", current);
//		req.setAttribute("emps", empdao.getEmployeeByDepartment(current.getId()));
//		req.setAttribute("dept", current);
//
//		Cookie [] cookies=req.getCookies();
//		for(int i=0;i<cookies.length;i++) {
//			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
//		}
//		
//		resp.addCookie(new Cookie("operation",operation));
//		req.getRequestDispatcher("depts.jsp").forward(req,resp);
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		req.setAttribute("dept",deptdao.first());
//		HttpSession session=req.getSession();
//		if((Boolean)req.getAttribute("flag")!=null && (Boolean)req.getAttribute("flag")==true) {
//			req.setAttribute("dept",session.getAttribute("current"));
//			req.getRequestDispatcher("/depts.jsp").forward(req, resp);
//			return;
////			session.setAttribute("current",session.getAttribute("current"));
////			System.out.println(req.getAttribute("emps"));
//		}
//		else
//		{
//			
//		req.setAttribute("emps",empdao.getEmployeeByDepartment(deptdao.first().getId()));
//		session.setAttribute("current",deptdao.first());
//		}
////		session.setAttribute("current",deptdao.first());
//
//		req.getRequestDispatcher("/depts.jsp").forward(req, resp);
//        
//	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		Dept current =(Dept) session.getAttribute("current");
 
		if(current == null) {
			current = deptdao.first();
		} else {
			if("First".equals(operation)) {
				current = deptdao.first();
			} else if("Last".equals(operation)) {
				current = deptdao.last();
			} else if("Previous".equals(operation)) {
				current = deptdao.previous(current.getId());
			}
			else {
				current = deptdao.next(current.getId());
			}
		}
 
		session.setAttribute("current", current);
	    session.setAttribute("employeeByDept", empdao.getEmployeeByDepartment(current.getId()));
	    req.setAttribute("dept", current);
 
 
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", deptdao.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
			}
		
 
		
		Dept depts = Dept.builder().id(Integer.parseInt(req.getParameter("id")))
				.name(req.getParameter("name")).location(req.getParameter("location")).build();
		if("Update".equals(operation)) {
			deptdao.update(depts);
			req.setAttribute("depts",deptdao.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		if("Save".equals(operation)) {
			deptdao.save(depts);
			req.setAttribute("depts",deptdao.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		


		Cookie [] cookies = req.getCookies();
		for(int i =0;i<cookies.length;i++) {
			System.out.println(cookies[i].getName()+" "+cookies[i].getValue());
		}
 
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setAttribute("dept", deptdao.first());
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		session.setAttribute("current", deptdao.first());
		Dept current=(Dept) session.getAttribute("current");
	
	
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Dept d = deptdao.get(id);
			req.setAttribute("depts", d);
			req.setAttribute("mode", "Update");
			req.setAttribute("readonly", "readonly");
			req.getRequestDispatcher("editDepartment.jsp").forward(req,resp);
			return;
			}
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			deptdao.delete(id);
			req.setAttribute("depts", deptdao.getAll());
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editDepartment.jsp").forward(req,resp);
			return;
		}
		session.setAttribute("employeeByDept", empdao.getEmployeeByDepartment(current.getId()));
		req.setAttribute("depts", deptdao.getAll());
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
	}

}

