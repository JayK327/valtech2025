package assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import assignment1.Employee.Gender;

class EmployeeTest {
	
	private Collection<Employee> employees;
	
	@Test
	void test() {
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(Employee.builder().id(11).name("Amit").
				age(30).salary(105000).gender(Gender.MALE).level(2)
				.experience(5).build());
		employees.add(Employee.builder().id(12).name("Raj")
				.age(28).salary(60000).gender(Gender.MALE)
				.level(1).experience(3).build());
		employees.add(Employee.builder().id(13).name("Neha")
				.age(26).salary(92000).gender(Gender.FEMALE)
				.level(1).experience(2).build());
		employees.add(Employee.builder().id(14).name("Pooja").
				age(32).salary(62000).gender(Gender.FEMALE).level(3)
				.experience(6).build());
		employees.add(Employee.builder().id(15).name("Suresh")
				.age(45).salary(75000).gender(Gender.MALE)
				.level(13).experience(15).build());
		employees.add(Employee.builder().id(16).name("Kunal")
				.age(40).salary(95000).gender(Gender.MALE)
				.level(9).experience(10).build());
		employees.add(Employee.builder().id(17).name("Simran").
				age(29).salary(65000).gender(Gender.FEMALE).level(4)
				.experience(5).build());
		employees.add(Employee.builder().id(18).name("Meera")
				.age(38).salary(78000).gender(Gender.FEMALE)
				.level(8).experience(9).build());
		
	List<Employee> myEmp1 = employees.stream().filter(emp -> emp.getLevel()>0)
			.collect(Collectors.toList());
	System.out.println(myEmp1);
	System.out.println("Salary by Level "+myEmp1.stream().mapToDouble(Employee :: getSalary).sum());
	
	List<Employee> myEmp2 = employees.stream().filter(emp -> emp.getGender()==Gender.MALE)
			.collect(Collectors.toList());
	System.out.println(myEmp2);
	System.out.println("Salary by Gender "+myEmp2.stream().mapToDouble(Employee :: getSalary).sum());

	List<Employee> myEmp3 = employees.stream().filter(emp -> emp.getName().equalsIgnoreCase("Amit"))
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
		Employee emp = new Employee(1,"Amit",30,105000,Gender.MALE,2,5);
		int hash = emp.hashCode();
		System.out.println(emp +" "+emp.hashCode());
		assertEquals(hash, emp.hashCode());
		assertEquals(hash,new Employee(1,"Amit",30,105000,Gender.MALE,2,5).hashCode());
		emp.setAge(31);
		System.out.println(emp +" "+emp.hashCode());
		emp.setLevel(5);
		System.out.println(emp+" "+emp.hashCode());
		assertNotEquals(hash, emp.hashCode());
		emp.setName("Rohan");
		System.out.println(emp +" "+emp.hashCode());
		assertNotEquals(hash, emp.hashCode());
	}

	@Test
	void testEquals() {
		Employee emp1 = new Employee(1, "Amit", 30, 105000, Gender.MALE, 2, 5);
		Employee emp2 = new Employee(1, "Amit", 30, 105000, Gender.MALE, 2, 5);
		Employee emp3 = new Employee(2, "Raj", 28, 60000, Gender.MALE, 1, 3);

		assertTrue(emp1.equals(emp2), "Objects with identical attributes should be equal");
		assertFalse(emp1.equals(emp3), "Objects with different attributes should not be equal");
		assertTrue(emp1.equals(emp1), "An object should be equal to itself");
		assertFalse(emp1.equals(null), "An object should not be equal to null");
		assertFalse(emp1.equals("Some String"), "An object should not be equal to an instance of a different class");
	}

	@Test
	void testCompareTo() {
		Employee emp1 = new Employee(1, "Amit", 30, 105000, Gender.MALE, 2, 5);
		Employee emp2 = new Employee(2, "Raj", 28, 60000, Gender.MALE, 1, 3);
		Employee emp3 = new Employee(3, "Neha", 26, 92000, Gender.FEMALE, 1, 2);
		

		assertTrue(emp1.compareTo(emp2) < 0, "Employee with a lower level should come first");
		assertTrue(emp2.compareTo(emp1) > 0, "Employee with a higher level should come after");
		assertTrue(emp1.compareTo(emp3) == 0, "Employees with the same level and experience should be equal");
	}
}
