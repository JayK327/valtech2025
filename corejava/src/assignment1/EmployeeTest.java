package assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collector;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import assignment1.Employee.Gender;


class EmployeeTest {
	
	private Collection<Employee> employees;
	
	@Test
	void test() {
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(Employee.builder().id(11).name("Rudraksh").
				age(22).salary(99000).gender(Gender.MALE).level(2)
				.experience(2).build());
		employees.add(Employee.builder().id(12).name("John")
				.age(23).salary(55000).gender(Gender.MALE)
				.level(1).experience(1).build());
		employees.add(Employee.builder().id(13).name("Yash")
				.age(23).salary(88000).gender(Gender.MALE)
				.level(1).experience(1).build());
		employees.add(Employee.builder().id(14).name("Anukrati").
				age(25).salary(59000).gender(Gender.FEMALE).level(3)
				.experience(3).build());
		employees.add(Employee.builder().id(15).name("Mahesh")
				.age(40).salary(65000).gender(Gender.MALE)
				.level(13).experience(10).build());
		employees.add(Employee.builder().id(16).name("Yogesh")
				.age(38).salary(89000).gender(Gender.MALE)
				.level(9).experience(9).build());
		employees.add(Employee.builder().id(17).name("Surbhi").
				age(27).salary(60000).gender(Gender.FEMALE).level(4)
				.experience(4).build());
		employees.add(Employee.builder().id(18).name("Alka")
				.age(35).salary(70000).gender(Gender.FEMALE)
				.level(8).experience(8).build());
		
	
	
	List<Employee> myEmp1 = employees.stream().filter(emp -> emp.getLevel()>0)
			.collect(Collectors.toList());
	
	System.out.println(myEmp1);
	System.out.println("Salary by Level "+myEmp1.stream().mapToDouble(Employee :: getSalary).sum());
	
	List<Employee> myEmp2 = employees.stream().filter(emp -> emp.getGender()==Gender.MALE)
			.collect(Collectors.toList());
	System.out.println(myEmp2);
	System.out.println("Salary by Gender "+myEmp2.stream().mapToDouble(Employee :: getSalary).sum());

	
	List<Employee> myEmp3 = employees.stream().filter(emp -> emp.getName().equalsIgnoreCase("Rudraksh"))
			.collect(Collectors.toList());
	System.out.println("case"+myEmp3);
	System.out.println("Salary by IgnoreCase "+myEmp3.stream().mapToDouble(Employee :: getSalary).sum());

	
	List<Employee> myEmp4 = employees.stream().filter(emp -> emp.getLevel()>0 && emp.getGender() == Gender.MALE)
			.collect(Collectors.toList());
	System.out.println(myEmp4);
	System.out.println("Salary by Level and Gender "+myEmp4.stream().mapToDouble(Employee :: getSalary).sum());

	
	
	
	Map<Gender,List<Employee>> mp = employees.stream().collect(Collectors.groupingBy(Employee :: getGender));
	System.out.println(mp);
	
	
	}
	
	@Test
	void testhashcode() {
		Employee emp = new Employee(1,"Rudraksh",22,99000,Gender.MALE,2,2);
		int hash = emp.hashCode();
		System.out.println(emp +" "+emp.hashCode());
		assertEquals(hash, emp.hashCode());
		assertEquals(hash,new Employee(1,"Rudraksh",22,99000,Gender.MALE,2,2).hashCode());
		emp.setAge(23);
		System.out.println(emp +" "+emp.hashCode());
		emp.setLevel(5);
		System.out.println(emp+" "+emp.hashCode());
		assertNotEquals(hash, emp.hashCode());
		emp.setName("Rohit");
		System.out.println(emp +" "+emp.hashCode());
		assertNotEquals(hash, emp.hashCode());
	}
	
	@Test
	void testEquals() {
	    Employee emp1 = new Employee(1, "Rudraksh", 22, 99000, Gender.MALE, 2, 2);
	    Employee emp2 = new Employee(1, "Rudraksh", 22, 99000, Gender.MALE, 2, 2);
	    Employee emp3 = new Employee(2, "John", 25, 55000, Gender.MALE, 3, 4);

	    // Test equality for identical attributes
	    assertTrue(emp1.equals(emp2), "Objects with identical attributes should be equal");

	    // Test inequality for different attributes
	    assertFalse(emp1.equals(emp3), "Objects with different attributes should not be equal");

	    // Test equality with itself
	    assertTrue(emp1.equals(emp1), "An object should be equal to itself");

	    // Test inequality with null
	    assertFalse(emp1.equals(null), "An object should not be equal to null");

	    // Test inequality with a different class object
	    assertFalse(emp1.equals("Some String"), "An object should not be equal to an instance of a different class");
	}
	@Test
	void testCompareTo() {
	    Employee emp1 = new Employee(1, "Rudraksh", 22, 99000, Gender.MALE, 2, 2);
	    Employee emp2 = new Employee(2, "John", 25, 55000, Gender.MALE, 3, 4);
	    Employee emp3 = new Employee(3, "Yash", 22, 99000, Gender.MALE, 2, 2);
	    Employee emp4 = new Employee(4, "Dolly", 25, 55000, Gender.FEMALE, 2, 2);

	    // Test ascending level
	    assertTrue(emp1.compareTo(emp2) < 0, "Employee with a lower level should come first");
	    assertTrue(emp2.compareTo(emp1) > 0, "Employee with a higher level should come after");

	    // Test same level, compare by experience
	    assertTrue(emp1.compareTo(emp3) == 0, "Employees with the same level and experience should be equal");
	}
	
	
	
}
