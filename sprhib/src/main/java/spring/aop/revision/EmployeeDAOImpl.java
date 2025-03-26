package spring.aop.revision;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import spring.tx.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	public Employee save(Session ses,Employee e) {
		long id=(Long) ses.save(e);
		return (Employee)ses.load(Employee.class, id);
	}
	private Employee get(Session ses,long id) {
		return (Employee)ses.load(Employee.class, id);
	}
	
	public Employee update(Session ses,Employee e) {
		ses.update(e);
		return get(ses,e.getId());
	}
}
