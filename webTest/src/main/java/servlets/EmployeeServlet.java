package servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import dao.Employee;
import dao.Employee.Gender;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns="/employees")
public class EmployeeServlet extends HttpServlet{
	
	private EmployeeDAO dao;
	public void init(ServletConfig config) throws ServletException{
//		dao=(EmployeeDAOImpl)config.getServletContext().getAttribute("emp");
		ServletContext sc = config.getServletContext();
		dao=new EmployeeDAOImpl(sc);		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation=req.getParameter("operation");
		HttpSession session=req.getSession();
		String options=req.getParameter("options");
		
		List<Employee> l=dao.getAll();;
			try {	
			    // Filter by Name (String)
			    if ("Names".equals(req.getParameter("pars"))) { 
			        String nameValue = req.getParameter("name");

			        if (nameValue != null && !nameValue.isEmpty()) {
			            l = l.stream().filter(emp -> emp.getName().toLowerCase().contains(nameValue.toLowerCase()))
			                    .collect(Collectors.toList());

			            req.setAttribute("filter", true);
			        }
			    }
			    // Filter by Age (Integer)
			    if ("Age".equals(req.getParameter("ages"))) { 
			        String ageOperation = req.getParameter("age"); 
			        String ageValueStr = req.getParameter("A");

			        if (ageValueStr != null && !ageValueStr.isEmpty()) {
			            int ageValue = Integer.parseInt(ageValueStr);

			            l = l.stream().filter(emp -> {
			                if ("greater".equalsIgnoreCase(ageOperation)) return emp.getAge() > ageValue;
			                if ("lesser".equalsIgnoreCase(ageOperation)) return emp.getAge() < ageValue;
			                return emp.getAge() == ageValue; // Default to equals
			            }).collect(Collectors.toList());

			            req.setAttribute("filter", true);
			        }
			    }

			    try {
		            // Filter by Gender (String)
		            if ("Gender".equals(req.getParameter("gend"))) { 
		                String genderValueStr = req.getParameter("C"); // Get gender input value

		                if (genderValueStr != null && !genderValueStr.isEmpty()) {
		                    try {
		                        Gender genderValue = Gender.valueOf(genderValueStr.toUpperCase()); // Convert to Enum (if applicable)

		                        l = l.stream().filter(emp -> emp.getGender().equals(genderValue)).collect(Collectors.toList());

		                        req.setAttribute("filter", true);
		                    } catch (IllegalArgumentException e) {
		                        req.setAttribute("error", "Invalid gender value. Please enter a valid gender.");
		                    }
		                }
		            }
		            // Set the filtered employee list
		            req.setAttribute("emps", l);

		        } catch (Exception e) {
		            req.setAttribute("error", "An error occurred while processing the request.");
		        }

			    // Filter by Experience
			    if ("Experience".equals(req.getParameter("exp"))) { 
			        String experienceOperation = req.getParameter("expr"); 
			        String experienceValueStr = req.getParameter("D");

			        if (experienceValueStr != null && !experienceValueStr.isEmpty()) {
			            int experienceValue = Integer.parseInt(experienceValueStr);

			            l = l.stream().filter(emp -> {
			                if ("greater".equalsIgnoreCase(experienceOperation)) return emp.getExperience() > experienceValue;
			                if ("lesser".equalsIgnoreCase(experienceOperation)) return emp.getExperience() < experienceValue;
			                return emp.getExperience() == experienceValue; // Default to equals
			            }).collect(Collectors.toList());

			            req.setAttribute("filter", true);
			        }
			    }

			    // Filter by Level
			    if ("Level".equals(req.getParameter("level"))) {
			        String levelOperation = req.getParameter("levelr");
			        String levelValueStr = req.getParameter("E");

			        if (levelValueStr != null && !levelValueStr.isEmpty()) {
			            int levelValue = Integer.parseInt(levelValueStr);

			            l = l.stream().filter(emp -> {
			                if ("greater".equalsIgnoreCase(levelOperation)) return emp.getLevel() > levelValue;
			                if ("lesser".equalsIgnoreCase(levelOperation)) return emp.getLevel() < levelValue;
			                return emp.getLevel() == levelValue; // Default to equals
			            }).collect(Collectors.toList());

			            req.setAttribute("filter", true);
			        }
			    }
			    

			    // Filter by Salary (Float)
			    if ("Salary".equals(req.getParameter("sal"))) { 
			        String salaryOperation = req.getParameter("salary"); 
			        String salaryValueStr = req.getParameter("B");

			        if (salaryValueStr != null && !salaryValueStr.isEmpty()) {
			            float salaryValue = Float.parseFloat(salaryValueStr);

			            l = l.stream().filter(emp -> {
			                if ("greater".equalsIgnoreCase(salaryOperation)) return emp.getSalary() > salaryValue;
			                if ("lesser".equalsIgnoreCase(salaryOperation)) return emp.getSalary() < salaryValue;
			                return emp.getSalary() == salaryValue; // Default to equals
			            }).collect(Collectors.toList());

			            req.setAttribute("filter", true);
			        }
			    }
			    
			    if ("Deptid".equals(req.getParameter("deptid"))) { 
			    	String deptidOperation = req.getParameter("deptid_option"); 
			        String deptidValueStr = req.getParameter("F");

			        if (deptidValueStr != null && !deptidValueStr.isEmpty()) {
			            int deptidValue = Integer.parseInt(deptidValueStr);

			            l = l.stream().filter(emp -> {
			                if ("greater".equalsIgnoreCase(deptidOperation)) return emp.getSalary() > deptidValue;
			                if ("lesser".equalsIgnoreCase(deptidOperation)) return emp.getSalary() < deptidValue;
			                return emp.getDeptid() == deptidValue; // Default to equals
			            }).collect(Collectors.toList());

			            req.setAttribute("filter", true);
			        }
			    }

			    // Set employees list after filtering
			    req.setAttribute("emps", l);

			} catch (NumberFormatException e) {
			    req.setAttribute("error", "Invalid input value. Please enter a valid number.");
			}

			Boolean filters = (Boolean) req.getAttribute("filter");
			if(filters!=null && filters==true) {
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
		

		if("SortByName".equals(operation)) {
			Boolean a=(Boolean)session.getAttribute("SortByName");
			System.out.println(a);
			
			
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByName",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->o2.getName().compareTo(o1.getName())).collect(Collectors.toList()));
				session.setAttribute("SortByName", false);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
		}
		if("SortByGender".equals(operation)) {
			Boolean a=(Boolean)session.getAttribute("SortByName");
			System.out.println(a);
			
			
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->o1.getGender().compareTo(o2.getGender())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByName",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->o2.getGender().compareTo(o1.getGender())).collect(Collectors.toList()));
				session.setAttribute("SortByName", false);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
		}
		
		else if("SortByAge".equals(operation)) {
			Boolean a=(Boolean)session.getAttribute("SortByAge");
			System.out.println(a);
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->Integer.compare(o1.getAge(), o2.getAge())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByAge",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				System.out.println("Sort by Age True");
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->Integer.compare(o2.getAge(),o1.getAge())).collect(Collectors.toList()));
				session.setAttribute("SortByAge", false);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
		}
		else if("SortBySalary".equals(operation)) {
		    Boolean a = (Boolean) session.getAttribute("SortBySalary");
		    System.out.println(a);

		    if (a == null || !a) {
		        List<Employee> emp = dao.getAll();
		        emp = emp.stream()
		                 .sorted((o1, o2) -> Float.compare(o1.getSalary(), o2.getSalary()))
		                 .collect(Collectors.toList());

		        System.out.println(emp);
		        req.setAttribute("emps", emp);
		        session.setAttribute("SortBySalary", true);
		        req.getRequestDispatcher("employees.jsp").forward(req, resp);
		        return;
		    } else {
		        System.out.println("Sort by Salary Descending");
		        req.setAttribute("emps", dao.getAll().stream()
		                 .sorted((o1, o2) -> Float.compare(o2.getSalary(), o1.getSalary()))
		                 .collect(Collectors.toList()));
		        session.setAttribute("SortBySalary", false);
		        req.getRequestDispatcher("employees.jsp").forward(req, resp);
		        return;
		    }
		}

		else if("SortByExperience".equals(operation)) {
			Boolean a=(Boolean)session.getAttribute("SortByExperience");
			System.out.println(a);
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->Integer.compare(o1.getExperience(), o2.getExperience())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByExperience",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				System.out.println("Sort by Experience True");
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->Integer.compare(o2.getExperience(),o1.getExperience())).collect(Collectors.toList()));
				session.setAttribute("SortByExperience", false);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
		}
		else if("SortByLevel".equals(operation)) {
			Boolean a=(Boolean)session.getAttribute("SortByLevel");
			System.out.println(a);
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->Integer.compare(o1.getLevel(), o2.getLevel())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByLevel",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				System.out.println("Sort by Level True");
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->Integer.compare(o2.getLevel(),o1.getLevel())).collect(Collectors.toList()));
				session.setAttribute("SortByLevel", false);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
		}
		else if("SortByDept".equals(operation)) {
			Boolean a=(Boolean)session.getAttribute("SortByDept");
			System.out.println(a);
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->Integer.compare(o1.getDeptid(), o2.getDeptid())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByDept",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				System.out.println("Sort by Dept True");
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->Integer.compare(o2.getDeptid(),o1.getDeptid())).collect(Collectors.toList()));
				session.setAttribute("SortByDept", false);
				req.getRequestDispatcher("employees.jsp").forward(req, resp);
				return;
			}
			
		}
		else if("new".equals(operation)) {
			req.setAttribute("mode","Save");
//			req.setAttribute("readOnly", "");
			req.setAttribute("emp", new Employee()); 
			req.getRequestDispatcher("editEmployee.jsp").forward(req,resp);
			return;
		}
		else if("Delete".equals(operation)) {
			int id=Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps",dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);  //employee.jsp
			return;
		}
		else if("Update".equals(operation)) {
		    req.setAttribute("readOnly","readOnly");
		    int id = Integer.parseInt(req.getParameter("id"));

		    Employee e = dao.get(id); 

		    if (e != null) {
		        req.setAttribute("emp", e);  
		        req.setAttribute("mode", "Update");
		        req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
		    } else {
		        req.setAttribute("error", "Employee not found.");
		        req.getRequestDispatcher("employees.jsp").forward(req, resp);
		    }
		    return;
		}
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);
		return;
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		// TODO Auto-generated method stub
		String operation=req.getParameter("operation");
		System.out.println(operation);
	
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req,resp);
			return;
		}

		String genderParam = req.getParameter("gender");


	        Employee emp = Employee.builder()
	            .id(Integer.parseInt(req.getParameter("id")))
	            .name(req.getParameter("name"))
	            .age(Integer.parseInt(req.getParameter("age")))
	            .gender(Gender.valueOf(genderParam.trim().toUpperCase()))
	            .salary(Float.parseFloat(req.getParameter("salary")))
	            .experience(Integer.parseInt(req.getParameter("experience")))
	            .level(Integer.parseInt(req.getParameter("level")))
	            .deptid(Integer.parseInt(req.getParameter("deptid")))
	            .build();

			if("Save".equals(operation)) {
				System.out.println(emp);
				dao.save(emp);
				req.setAttribute("emps", dao.getAll());
				System.out.println(req.getAttribute("emps"));
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
			}
			if("Update".equals(operation)) {
				dao.update(emp);
				System.out.println(dao.getAll());
				req.setAttribute("emps", dao.getAll());
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
			}

	}
}



