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
		dao=(EmployeeDAOImpl)config.getServletContext().getAttribute("emp");
		
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
			        String ageValueStr = req.getParameter("ab");

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
		                String genderValueStr = req.getParameter("ef"); // Get gender input value

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
			        String experienceValueStr = req.getParameter("gh");

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
			        String levelValueStr = req.getParameter("ij");

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
			        String salaryValueStr = req.getParameter("cd");

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
			Boolean a=(Boolean)session.getAttribute("SortByAge");
			System.out.println(a);
		 if(a==null || !a)
			{
			 	List<Employee> emp=dao.getAll();
			 	emp=emp.stream().sorted((o1,o2)->Integer.compare(o1.getExperience(), o2.getExperience())).collect(Collectors.toList());
			 	
			 	System.out.println(emp);
				req.setAttribute("emps",emp);
				session.setAttribute("SortByAge",true);
				req.getRequestDispatcher("employees.jsp").forward(req,resp);
				return;
				
			}
			else if(a) {
				System.out.println("Sort by Age True");
				req.setAttribute("emps", dao.getAll().stream().sorted((o1,o2)->Integer.compare(o2.getExperience(),o1.getExperience())).collect(Collectors.toList()));
				session.setAttribute("SortByAge", false);
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

		    // Fetch employee
		    Employee e = dao.get(id); // Ensure this returns an Employee, not DAO

		    if (e != null) {
		        req.setAttribute("emp", e);  // Make sure "emp" is an Employee instance
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


	    try {
	        // Retrieve gender safely
	        String genderParam = req.getParameter("gender");
	        Gender gender = null;
	        if (genderParam != null && !genderParam.trim().isEmpty()) {
	            try {
	                gender = Gender.valueOf(genderParam.trim().toUpperCase());
	            } catch (IllegalArgumentException e) {
	                throw new IllegalArgumentException("Invalid gender value: " + genderParam);
	            }
	        } else {
	            throw new IllegalArgumentException("Gender cannot be null or empty.");
	        }

	        // Create Employee object safely
	        Employee emp = Employee.builder()
	            .id(Integer.parseInt(req.getParameter("id")))
	            .name(req.getParameter("name"))
	            .age(Integer.parseInt(req.getParameter("age")))
	            .gender(gender)
	            .salary(Float.parseFloat(req.getParameter("salary")))
	            .experience(Integer.parseInt(req.getParameter("experience")))
	            .level(Integer.parseInt(req.getParameter("level")))
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

	    } catch (IllegalArgumentException e) {
	        req.setAttribute("errorMessage", "Invalid input: " + e.getMessage());
	        req.getRequestDispatcher("newEmployee.jsp").forward(req, resp);
	    }
		{
			String abc=req.getParameter("options");
			System.out.println(abc);

		}
	}
}



