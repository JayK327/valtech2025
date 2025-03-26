package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import assignment1.Employee.Gender;

public class EmployeeService {

	public static Map<Gender,List<Employee>> getEmpByLevel(List<Employee> emps,int level){
		return emps.stream().filter(e->e.getLevel()==level).sorted((emp1,emp2)->emp1.compareTo(emp2)).collect(Collectors.groupingBy(e->e.getGender()));
	// return emps.stream().filter(e->e.getLevel()==level).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	
	public static Map<Gender,List<Employee>> getEmpByGender(List<Employee> emps,Gender gender){
		return emps.stream().filter(e->e.getGender()==gender).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	
	public static Map<Gender,List<Employee>> getEmpByExactName(List<Employee> emps,String name){
		return emps.stream().filter(e->e.getName()==name).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	public static Map<Gender,List<Employee>> getEmpBySubstringName(List<Employee> emps,String substringName){
		return emps.stream().filter(e->e.getName().contains(substringName)).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	public static Map<Gender,List<Employee>> getEmpBySubstringNameIgnoreCase(List<Employee> emps,String substringName){
		return emps.stream().filter(e->e.getName().toUpperCase().contains(substringName.toUpperCase())).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}
	public static Map<Gender,List<Employee>> getEmpByGenderAndLevel(List<Employee> emps,Gender gender,int level){
		return emps.stream().filter(e->e.getGender()==gender && e.getLevel()==level).sorted(Employee::compareTo).collect(Collectors.groupingBy(Employee::getGender));
	}

	public static double getTotalSumOfSalary(List<Employee> emps) {
		return emps.stream().mapToDouble(Employee::getSalary).sum();
	}
	public static Map<Gender,List<Employee>> getAllEmp(List<Employee>emps){
		 return emps.stream().collect(Collectors.groupingBy(e -> e.getGender()));
	    }
	public static List<Employee> employee(){
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(Employee.builder().id(1).name("Rohit").
				age(30).salary(75000).gender(Gender.MALE).level(2)
				.experience(5).build());
		employees.add(Employee.builder().id(2).name("Virat")
				.age(28).salary(80000).gender(Gender.MALE)
				.level(1).experience(3).build());
		employees.add(Employee.builder().id(3).name("Neha")
				.age(26).salary(52000).gender(Gender.FEMALE)
				.level(1).experience(7).build());
		employees.add(Employee.builder().id(4).name("Pooja").
				age(32).salary(62000).gender(Gender.FEMALE).level(3)
				.experience(6).build());
		employees.add(Employee.builder().id(5).name("Suresh")
				.age(30).salary(75000).gender(Gender.MALE)
				.level(5).experience(6).build());
		employees.add(Employee.builder().id(6).name("Kunal")
				.age(40).salary(55000).gender(Gender.MALE)
				.level(6).experience(7).build());
		employees.add(Employee.builder().id(7).name("Simran").
				age(32).salary(55000).gender(Gender.FEMALE).level(4)
				.experience(5).build());
		employees.add(Employee.builder().id(8).name("Anjali")
				.age(26).salary(70000).gender(Gender.FEMALE)
				.level(6).experience(4).build());
		employees.add(Employee.builder().id(9).name("Hardik")
				.age(28).salary(80000).gender(Gender.MALE)
				.level(5).experience(3).build());
		employees.add(Employee.builder().id(10).name("Esha")
				.age(27).salary(68000).gender(Gender.FEMALE)
				.level(3).experience(4).build());
		return employees;
	}
}
