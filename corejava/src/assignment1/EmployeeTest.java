package assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assignment1.Employee.Gender;

class EmployeeTest {
	
	EmployeeService employeeService;
	private List<Employee> employees=employeeService.employee();
	
    @Test
    void testGetEmpByLevel() {
    	System.out.println("------------testGetEmpByLevel----------");
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getEmpByLevel(employees, 5);
        assertEquals(1, result.size()); //Hardik and suresh only male
        Map<Employee.Gender, List<Employee>> result1 = EmployeeService.getEmpByLevel(employees, 6);
        assertEquals(2, result1.size()); //Anjali and Kunal both gender
            
        result.forEach((gender, employeeList) -> {
            System.out.println("Gender: " + gender);
            employeeList.forEach(employee -> System.out.println(employee.getName()));
        });
        System.out.println("-------------");
        result1.forEach((gender, employeeList) -> {
            System.out.println("Gender: " + gender);
            employeeList.forEach(employee -> System.out.println(employee.getName()));
        });
        assertTrue(result1.containsKey(Employee.Gender.MALE));
        assertTrue(result1.containsKey(Employee.Gender.FEMALE));
        assertTrue(result.containsKey(Employee.Gender.MALE));
        
        List<Employee> maleEmp = result.get(Employee.Gender.MALE);
        assertEquals(2, maleEmp.size());
    }
    @Test
    void testGetEmpByGender() {
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getEmpByGender(employees, Employee.Gender.MALE);
        assertEquals(5, result.get(Employee.Gender.MALE).size());
        Map<Employee.Gender, List<Employee>> result1 = EmployeeService.getEmpByGender(employees, Employee.Gender.FEMALE);
        assertEquals(5, result1.get(Employee.Gender.FEMALE).size());
    }

    @Test
    void testGetEmpByExactName() {
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getEmpByExactName(employees, "Virat");
        assertNotEquals(2, result.get(Employee.Gender.MALE).size());
        Map<Employee.Gender, List<Employee>> result1 = EmployeeService.getEmpByExactName(employees, "Rahul");
        assertNull(result1.get(Employee.Gender.MALE));
   
        }

    @Test
    void testGetEmpBySubstringNameIgnoreCase() {
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getEmpBySubstringNameIgnoreCase(employees, "e");
        assertEquals(1, result.get(Employee.Gender.MALE).size());   //Suresh
        assertEquals(2, result.get(Employee.Gender.FEMALE).size());  //Neha ,Esha
        assertEquals(2, result.size());
        
    }
    @Test
    void testGetEmpBySubstringName() {
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getEmpBySubstringName(employees, "e");
        
        assertEquals(1, result.get(Employee.Gender.MALE).size());   //Suresh 
        assertEquals(1, result.get(Employee.Gender.FEMALE).size()); //Neha
        assertEquals(2, result.size());
        
    }

    @Test
    void testGetEmpByGenderAndLevel() {
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getEmpByGenderAndLevel(employees, Employee.Gender.MALE, 5);
        assertEquals(2, result.get(Employee.Gender.MALE).size());
        assertTrue(result.containsKey(Employee.Gender.MALE));;
    }

    @Test
    void testGetTotalSumOfSalary() {
        double totalSalary = EmployeeService.getTotalSumOfSalary(employees);
        assertEquals(672000.0, totalSalary, 0.01);
    }

    @Test
    void testGetAllEmp() {
        Map<Employee.Gender, List<Employee>> result = EmployeeService.getAllEmp(employees);
        assertEquals(5, result.get(Employee.Gender.MALE).size());
        assertEquals(5, result.get(Employee.Gender.FEMALE).size());
        assertEquals(2, result.size());

    }
    Employee emp1 = new Employee(1, "Karan", 32, 68000f, Employee.Gender.MALE, 2, 6);
	Employee emp2 = new Employee(1, "Karan", 32, 90000f, Employee.Gender.MALE, 2, 6);
	Employee emp3 = new Employee(1, "Parth", 32, 68000f, Employee.Gender.MALE, 2, 6);
	Employee emp4 = new Employee(1, "Karan", 32, 68000f, Employee.Gender.MALE, 3, 6);
	Employee emp5 = new Employee(1, "Karan", 32, 68000f, Employee.Gender.FEMALE, 2, 6);
	Employee emp6 = new Employee(1, "Karan", 24, 68000f, Employee.Gender.MALE, 2, 6);
	Employee emp7 = new Employee(1, "Karan", 32, 68000f, Employee.Gender.MALE, 2, 7);
    Employee emp8 = new Employee(1, "Karan", 32, 68000f, Employee.Gender.MALE, 2, 6);

    
	@Test
	void testEquals() {


		assertTrue(emp1.equals(emp1));
        assertFalse(emp1.equals(emp2));
        assertFalse(emp1.equals(emp3));
        assertFalse(emp1.equals(null));
        assertFalse(emp1.equals("XYZ"));
		assertTrue(emp1.equals(emp8));
	}

	@Test
	void testCompareTo() {
		assertEquals(0, emp1.compareTo(emp1));
		assertTrue(emp1.compareTo(emp2) < 0);
		assertTrue(emp2.compareTo(emp1) > 0);
		assertTrue(emp1.compareTo(emp4) < 0);
		assertTrue(emp5.compareTo(emp1) > 0);
	}
	
	@Test
	void testhashcode() {
		assertEquals(emp1.hashCode(), emp1.hashCode());
        assertNotEquals(emp1.hashCode(), emp2.hashCode());
        assertNotEquals(emp1.hashCode(), emp3.hashCode());
        assertNotEquals(emp1.hashCode(), emp4.hashCode());
        assertNotEquals(emp1.hashCode(), emp5.hashCode());
        assertEquals(emp1.hashCode(), emp8.hashCode());
        assertNotEquals(emp1.hashCode(), emp6.hashCode());
        assertNotEquals(emp1.hashCode(), emp7.hashCode());
	}

	

}
